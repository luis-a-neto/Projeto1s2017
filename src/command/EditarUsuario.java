package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class EditarUsuario implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = new Usuario();
		UsuarioService usuarioService = new UsuarioService();
		
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setAcesso(request.getParameter("acesso"));
		
		try{
			HttpSession session = request.getSession();
			usuarioService.update(usuario);
			session.setAttribute("lista", usuarioService.list());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Usuarios/UsuarioListar.jsp");
			dispatcher.forward(request,response);
		}
		catch ( Exception e ){
		}
	}
}
