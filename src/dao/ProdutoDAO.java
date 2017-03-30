package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Produto;

public class ProdutoDAO {
	
	public int create(Produto produto){
		// Usando o Try com Resources do Java 7, seja lá como isso funciona
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("INSERT INTO Produto(precoCusto, precoVenda, nome, descricao, imagemURL) VALUES (?, ?, ?, ?, ?)")
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
				PreparedStatement statement = conexao.prepareStatement("SELECT * FROM Produto WHERE id = ?");
			){
			
			statement.setInt(1, produtoCarregado.getId());
			try (ResultSet resultado = statement.executeQuery();) {
				if (resultado.next()) {
					produtoCarregado.setId(idProduto);
					produtoCarregado.setNome(resultado.getString("nome"));
					produtoCarregado.setDescricao(resultado.getString("descricao"));
					produtoCarregado.setImagemURL(resultado.getString("imagemURL"));
					produtoCarregado.setQtde(resultado.getInt("qtde"));
					produtoCarregado.setPrecoCusto(resultado.getDouble("precoCusto"));
					produtoCarregado.setPrecoVenda(resultado.getDouble("precoVenda"));
					
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
				PreparedStatement statement = conexao.prepareStatement("UPDATE Produto SET precoCusto = ?, precoVenda = ?, nome = ?, descricao = ?, imagemURL = ?, qtde = ?) WHERE id = ?")
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
		try (	Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement("DELETE FROM Produtos WHERE id = ?");
			){
			stm.setInt(1, idProduto);
			stm.execute();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
