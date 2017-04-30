package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import model.Usuario;
import dao.UsuarioDAO;


public class CriarUsuario implements Command {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		String Login = request.getParameter("login");
		String Senha = request.getParameter("senha");
		String Acesso = request.getParameter("acesso");


		Usuario usuario = new Usuario();
		usuario.setLogin(Login);
		usuario.setSenha(Senha);
		usuario.setAcesso(Acesso);
		UsuarioDAO usuarioDao = new UsuarioDAO();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		usuarioDao.create(usuario);

		ArrayList<Usuario> lista = usuarioDao.list();
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("Usuarios/UsuarioListar.jsp");

		try {
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
