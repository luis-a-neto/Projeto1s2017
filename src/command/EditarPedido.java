package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdutoDAO;
import dao.ProdutoVendaDAO;
import dao.VendaDAO;

public class EditarPedido implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		VendaDAO vendaDao = new VendaDAO();
		ProdutoVendaDAO pvDao = new ProdutoVendaDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		try {

			int idVenda = -1;
			try {
				idVenda = Integer.parseInt(request.getParameter("venda"));
			} catch (NumberFormatException e) {
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("produtos", pvDao.list(idVenda));
			session.setAttribute("venda", vendaDao.read(idVenda));
			session.setAttribute("cardapio", produtoDao.list());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Vendas/VendaEditar.jsp");
			dispatcher.forward(request,response);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}

	}

}
