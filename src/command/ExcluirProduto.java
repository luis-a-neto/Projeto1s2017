package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdutoDAO;

public class ExcluirProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		try {
			
			int idProduto = -1;
			
			try{
				idProduto = Integer.parseInt(request.getParameter("Id"));
				produtoDao.delete(idProduto);
			} catch (NumberFormatException e) {
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("cardapio", produtoDao.list());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Produtos/ProdutoListar.jsp");
			dispatcher.forward(request,response);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

}
