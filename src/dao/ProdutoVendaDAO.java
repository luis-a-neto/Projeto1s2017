package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ProdutoVenda;
import model.Produto;
import model.Venda;

public class ProdutoVendaDAO {
	
	public int create(ProdutoVenda produtoVenda){
		
		int id = -1;
		
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("INSERT INTO Produto_Venda(COD_VENDA, COD_PRODUTO, QUANTIDADE) VALUES (?, ?, ?)");
			){
			
			statement.setInt(1, produtoVenda.getVenda().getId());
			statement.setInt(2, produtoVenda.getProduto().getId());
			statement.setInt(3, produtoVenda.getQtde());
			statement.execute();
			
			try (
					PreparedStatement statement2 = conexao.prepareStatement("SELECT LAST_INSERT_ID()");
					ResultSet resultado = statement2.executeQuery();
				){
				if (resultado.next()){
					id = resultado.getInt(1);
				}
			}
			catch (SQLException exception){
				exception.printStackTrace();
			}
			
			}
		catch (SQLException exception){
			exception.printStackTrace();
		}
		
		return id;
	}
	
	public ProdutoVenda read(int id){
		ProdutoVenda produtoVendaCarregado = new ProdutoVenda();
		
		// Usando o Try com Resources do Java 7, seja lá como isso funciona
				try (	Connection conexao = ConnectionFactory.obtemConexao();
						PreparedStatement statement = conexao.prepareStatement("SELECT * FROM Produto_Venda WHERE Cod_PV = ?");
					){
					
					statement.setInt(1, id);
					
					try (ResultSet resultado = statement.executeQuery();) {
						if (resultado.next()) {
							produtoVendaCarregado.setId(id);
							produtoVendaCarregado.setQtde(resultado.getInt("Quantidade"));

							VendaDAO vendaDAO = new VendaDAO();
							ProdutoDAO produtoDAO = new ProdutoDAO();
							
							Venda venda = vendaDAO.read(resultado.getInt("Cod_Venda"));
							Produto produto = produtoDAO.read(resultado.getInt("Cod_Produto"));
							
							produtoVendaCarregado.setVenda(venda);
							produtoVendaCarregado.setProduto(produto);
							
						}
						else {
							produtoVendaCarregado.setId(-1);
							produtoVendaCarregado.setQtde(-1);
							produtoVendaCarregado.setVenda(new Venda());
							produtoVendaCarregado.setProduto(new Produto());
						}
					}
					catch (SQLException exception){
							exception.printStackTrace();
					}
				}
				catch (SQLException exception){
					exception.printStackTrace();
				}
		
		return produtoVendaCarregado;
	}
	
	public void update(ProdutoVenda produtoVenda){
		// Usando o Try com Resources do Java 7, seja lá como isso funciona
		try (	Connection conexao = ConnectionFactory.obtemConexao();
			PreparedStatement statement = conexao.prepareStatement("UPDATE Produto_Venda SET Cod_Venda = ?, Cod_Produto = ?, Quantidade = ? WHERE Cod_PV = ?")
			){
			
			statement.setInt(1, produtoVenda.getVenda().getId());
			statement.setInt(2, produtoVenda.getProduto().getId());
			statement.setInt(3, produtoVenda.getQtde());
			statement.setInt(4, produtoVenda.getId());
			statement.execute();
		}
		catch (SQLException exception){
			exception.printStackTrace();
		}
	}
	
	public void delete(int id){
		try (	Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conn.prepareStatement("DELETE FROM Produto_Venda WHERE Cod_PV = ?");
			){
			statement.setInt(1, id);
			statement.execute();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public ArrayList<ProdutoVenda> list(int id){
		
		ArrayList<ProdutoVenda> lista = new ArrayList<ProdutoVenda>();
		
		try (	Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM Produto_Venda WHERE Cod_Venda = ?");
			){
			statement.setInt(1, id);
			
			try (ResultSet resultado = statement.executeQuery();) {
				while (resultado.next()) {
					ProdutoVenda produtoVendaCarregado = new ProdutoVenda();
					
					produtoVendaCarregado.setId(resultado.getInt("id"));
					produtoVendaCarregado.setQtde(resultado.getInt("Quantidade"));

					VendaDAO vendaDAO = new VendaDAO();
					ProdutoDAO produtoDAO = new ProdutoDAO();
					
					Venda venda = vendaDAO.read(resultado.getInt("Cod_Venda"));
					Produto produto = produtoDAO.read(resultado.getInt("Cod_Produto"));
					
					produtoVendaCarregado.setVenda(venda);
					produtoVendaCarregado.setProduto(produto);

					lista.add(produtoVendaCarregado);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return lista;
	}

}
