package service;

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

}
