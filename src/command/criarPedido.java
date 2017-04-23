package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import dao.VendaDAO;
import dao.ProdutoVendaDAO;
import model.ProdutoVenda;
import model.Venda;

public class criarPedido implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		VendaDAO vendaDao = new VendaDAO();
		ProdutoVendaDAO pvDao = new ProdutoVendaDAO();
		
		try {
			int idVenda = vendaDao.create();
			ArrayList<ProdutoVenda> listaProdutos = pvDao.list(idVenda);
			Venda venda = vendaDao.read(idVenda);
			
			HttpSession session = request.getSession();
			session.setAttribute("produtos", listaProdutos);
			session.setAttribute("venda", venda);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Vendas/VendaEditar.jsp");
			dispatcher.forward(request,response);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

}
