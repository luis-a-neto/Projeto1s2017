package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdutoVendaDAO;
import dao.VendaDAO;

public class ExcluirProdutoVenda implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProdutoVendaDAO pvDao = new ProdutoVendaDAO();
		VendaDAO vendaDao = new VendaDAO();
		
		try {
			
			int idProdutoVenda = -1;
			int idVenda = -1;
			
			try{
				idProdutoVenda = Integer.parseInt(request.getParameter("produtoVenda"));
				pvDao.delete(idProdutoVenda);
			} catch (NumberFormatException e) {
			}
			
			try{
				idVenda = Integer.parseInt(request.getParameter("venda"));
			} catch (NumberFormatException e) {
			}
			
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
