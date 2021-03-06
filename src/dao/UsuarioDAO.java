package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDAO{
	
	public void create(Usuario usuario){ // Não retorna porque o login do usuário e a senha serão fornecidos previamente. Qualquer coisa, só resetar a senha depois!
		
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("INSERT INTO Usuario(login, senha, acesso) VALUES (?, ?, ?)")
			){
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getAcesso());
			statement.execute();
			
			}
		catch (SQLException exception){
			exception.printStackTrace();
		}
	}
	
	public Usuario read(String login){
		Usuario usuarioCarregado = new Usuario();
		
		// Usando o Try com Resources do Java 7, seja lá como isso funciona
				try (	Connection conexao = ConnectionFactory.obtemConexao();
						PreparedStatement statement = conexao.prepareStatement("SELECT * FROM Usuario WHERE login = ?");
					){
					
					statement.setString(1, login);
					
					try (ResultSet resultado = statement.executeQuery();) {
						if (resultado.next()) {
							usuarioCarregado.setLogin(resultado.getString("login"));
							usuarioCarregado.setSenha(resultado.getString("senha")); // Seguro pra caralho.
							usuarioCarregado.setAcesso(resultado.getString("acesso"));
							
						}
						else {
							usuarioCarregado.setLogin(null);
							usuarioCarregado.setSenha(null);
							usuarioCarregado.setAcesso(null);
						}
					}
					catch (SQLException exception){
							exception.printStackTrace();
					}
				}
				catch (SQLException exception){
					exception.printStackTrace();
				}
		
		return usuarioCarregado;
	}
	
	public void update(Usuario usuario){
		// Usando o Try com Resources do Java 7, seja lá como isso funciona
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("UPDATE Usuario SET senha = ?, acesso = ? WHERE login = ?")
			){
			statement.setString(1, usuario.getSenha());
			statement.setString(2, usuario.getAcesso());
			statement.setString(3, usuario.getLogin());
			statement.execute();
		}
		catch (SQLException exception){
			exception.printStackTrace();
		}
	}
	
	public void delete(String login){
		try (	Connection conexao = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conexao.prepareStatement("DELETE FROM Usuario WHERE login = ?");
			){
			statement.setString(1, login);
			statement.execute();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public ArrayList<Usuario> list(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try (	Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM Usuario");
			){
			
			try (ResultSet resultado = statement.executeQuery();) {
				while (resultado.next()) {
					
					Usuario usuarioCarregado = new Usuario();
						usuarioCarregado.setLogin(resultado.getString("login"));
						usuarioCarregado.setSenha(resultado.getString("senha"));
						usuarioCarregado.setAcesso(resultado.getString("acesso"));
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