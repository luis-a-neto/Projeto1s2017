package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Produto;

public class ProdutoDAO {
	
	public int create(Produto produto){
		// Usando o Try com Resources do Java 7, seja lá como isso funciona...
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("INSERT INTO Estoque (Preco_Custo, Preco_Venda, Nome, Descricao, Imagem_URL) VALUES (?, ?, ?, ?, ?)")
			){
			statement.setDouble(1, produto.getPrecoCusto());
			statement.setDouble(2, produto.getPrecoVenda());
			statement.setString(3, produto.getNome());
			statement.setString(4, produto.getDescricao());
			statement.setString(5, produto.getImagemURL());
			statement.execute();
			
			try (
					PreparedStatement statement2 = conexao.prepareStatement("SELECT LAST_INSERT_ID()");
					ResultSet resultado = statement2.executeQuery();
				){
				if (resultado.next()){
					produto.setId(resultado.getInt(1));
				}
			}
			catch (SQLException exception){
				exception.printStackTrace();
			}
			
		}
		catch (SQLException exception){
			exception.printStackTrace();
		}
		
		return produto.getId();
	}
	
	public Produto read(int idProduto){
		Produto produtoCarregado = new Produto();
		
		// Usando o Try com Resources do Java 7, seja lá como isso funciona
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("SELECT * FROM Estoque WHERE Cod_Produto = ?");
			){
			
			statement.setInt(1, idProduto);
			
			try (ResultSet resultado = statement.executeQuery();) {
				if (resultado.next()) {
					produtoCarregado.setId(idProduto);
					produtoCarregado.setNome(		resultado.getString("Nome")			);
					produtoCarregado.setDescricao(	resultado.getString("Descricao")	);
					produtoCarregado.setImagemURL(	resultado.getString("Imagem_URL")	);
					produtoCarregado.setQtde(		resultado.getInt("Qtde")			);
					produtoCarregado.setPrecoCusto(	resultado.getDouble("Preco_Custo")	);
					produtoCarregado.setPrecoVenda(	resultado.getDouble("Preco_Venda")	);
					
				}
				else {
					produtoCarregado.setId(-1);
					produtoCarregado.setNome(null);
					produtoCarregado.setDescricao(null);
					produtoCarregado.setImagemURL(null);
					produtoCarregado.setQtde(-1);
					produtoCarregado.setPrecoCusto(-1.0);
					produtoCarregado.setPrecoVenda(-1.0);
				}
			}
			catch (SQLException exception){
					exception.printStackTrace();
			}
		}
		catch (SQLException exception){
			exception.printStackTrace();
		}
		
		return produtoCarregado;
	}
	
	public void update(Produto produto){
		// Usando o Try com Resources do Java 7, seja lá como isso funciona
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("UPDATE Estoque SET Preco_Custo = ?, Preco_Venda = ?, Nome = ?, Descricao = ?, ImagemURL = ?, Qtde = ? WHERE Cod_Produto = ?")
			){
			statement.setDouble(1, produto.getPrecoCusto());
			statement.setDouble(2, produto.getPrecoVenda());
			statement.setString(3, produto.getNome());
			statement.setString(4, produto.getDescricao());
			statement.setString(5, produto.getImagemURL());
			statement.setInt(6, produto.getQtde());
			statement.setInt(7, produto.getId());
			statement.execute();
		}
		catch (SQLException exception){
			exception.printStackTrace();
		}
	}
	
	public void delete(int idProduto){
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("DELETE FROM Estoque WHERE Cod_Produto = ?");
			){
			statement.setInt(1, idProduto);
			statement.execute();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	// TODO: Listar produtos.
}
