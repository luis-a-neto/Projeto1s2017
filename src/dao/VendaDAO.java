package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Venda;

public class VendaDAO {
	
	public int create(){ // Não precisa de argumentos. Coisa linda de Deus.
		
		int id = -1;
		
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("INSERT INTO Venda(Valor) VALUES (0.0)")
			){

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
	
	public Venda read(int venda){
		Venda vendaCarregada = new Venda();
		
		// Usando o Try com Resources do Java 7, seja lá como isso funciona
				try (	Connection conexao = ConnectionFactory.obtemConexao();
						PreparedStatement statement = conexao.prepareStatement("SELECT * FROM Venda WHERE Cod_Venda = ?");
					){
					
					statement.setInt(1, venda);
					
					try (ResultSet resultado = statement.executeQuery();) {
						if (resultado.next()) {
							vendaCarregada.setValorVenda(resultado.getDouble("Valor"));
							
						}
						else {
							vendaCarregada.setValorVenda(-1.0);
						}
					}
					catch (SQLException exception){
							exception.printStackTrace();
					}
				}
				catch (SQLException exception){
					exception.printStackTrace();
				}
		
		return vendaCarregada;
	}
	
	public void update(Venda venda){
		// Usando o Try com Resources do Java 7, seja lá como isso funciona
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("UPDATE Venda SET Valor= ? WHERE Cod_Venda = ?")
			){
			statement.setDouble(1, venda.getValorVenda());
			statement.setInt(2, venda.getId());
			statement.execute();
		}
		catch (SQLException exception){
			exception.printStackTrace();
		}
	}
	
	public void delete(int id){
		try (	Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conn.prepareStatement("DELETE FROM Venda WHERE Cod_Venda = ?");
			){
			statement.setInt(1, id);
			statement.execute();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public ArrayList<Venda> list(){
		ArrayList<Venda> lista = new ArrayList<Venda>();
		
		try (	Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM Venda");
			){
			
			try (ResultSet resultado = statement.executeQuery();) {
				while (resultado.next()) {
					
					Venda vendaCarregada = new Venda();
						vendaCarregada.setId(resultado.getInt("Id"));
						vendaCarregada.setValorVenda(resultado.getDouble("Valor"));
					}
				}
				catch (SQLException exception){
						exception.printStackTrace();
				}
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
