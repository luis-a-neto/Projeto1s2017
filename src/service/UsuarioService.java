package service;

// Imports para geração de senha aleatória.
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();

	public void create(Usuario usuario){
		dao.create(usuario);
	}
	
	public Usuario read(String id){
		return dao.read(id);
	}
	
	public void update(Usuario usuario){
		dao.update(usuario);
	}
	
	public void delete(String id){
		dao.delete(id);
	}
	
	
	public boolean validarSenha (String login, String senha){
		return senha == read(login).getSenha(); // Sou preguiçoso e meti tudo na mesma linha. Me julguem.
	}
	
	public String resetarSenha (String login){
		Usuario usuario = read(login);
		String senha = new BigInteger(130, new SecureRandom()).toString(32);
		usuario.setSenha(senha);
		update(usuario);
		return senha;
	}
	
	public ArrayList<Usuario> list(){
		return dao.list();
	}

}
