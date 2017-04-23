package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdutoVendaDAO;
import dao.VendaDAO;

public class CriarPedido implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		VendaDAO vendaDao = new VendaDAO();
		ProdutoVendaDAO pvDao = new ProdutoVendaDAO();
		
		try {
			
			int idVenda = vendaDao.create();
			
			HttpSession session = request.getSession();
			session.setAttribute("produtos", pvDao.list(idVenda));
			session.setAttribute("venda", vendaDao.read(idVenda));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Vendas/VendaEditar.jsp");
			dispatcher.forward(request,response);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

}
