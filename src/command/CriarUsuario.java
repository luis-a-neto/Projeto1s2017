package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import model.Usuario;
import service.UsuarioService;


public class CriarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) {
		String Login = request.getParameter("login");
		String Senha = request.getParameter("senha");
		String Acesso = request.getParameter("acesso");


		Usuario usuario = new Usuario();
		usuario.setLogin(Login);
		usuario.setSenha(Senha);
		usuario.setAcesso(Acesso);
		UsuarioService us = new UsuarioService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		criar(usuario);
		ArrayList<Usuario> lista = new ArrayList<>();
		lista.add(usuario);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("Vendas/VendaListar.jsp");

		view.forward(request, response);
	}
}
