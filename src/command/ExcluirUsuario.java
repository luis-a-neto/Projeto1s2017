package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class ExcluirUsuario implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		UsuarioService usuarioService = new UsuarioService();
		
		try{
			HttpSession session = request.getSession();
			usuarioService.delete(request.getParameter("login"));
			session.setAttribute("lista", usuarioService.list());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Produtos/ProdutoListar.jsp");
			dispatcher.forward(request,response);
		}
		catch ( Exception e ){
		}
	}

}
