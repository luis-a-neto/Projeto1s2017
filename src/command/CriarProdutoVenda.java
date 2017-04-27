package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdutoDAO;
import dao.ProdutoVendaDAO;
import dao.VendaDAO;
import model.Produto;
import model.ProdutoVenda;
import model.Venda;

public class CriarProdutoVenda implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProdutoVenda pv = new ProdutoVenda();
		Produto produto = null;
		Venda venda = null;
		
		ProdutoVendaDAO pvDao = new ProdutoVendaDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();
		VendaDAO vendaDao = new VendaDAO();
		
		int idVenda = -1;
		try {
			idVenda = Integer.parseInt(request.getParameter("venda"));
			venda = vendaDao.read(idVenda);
		} catch (NumberFormatException e) {
		}
		
		int idProduto = -1;
		try {
			idProduto = Integer.parseInt(request.getParameter("produto"));
			produto = produtoDao.read(idProduto);
		} catch (NumberFormatException e) {
		}
		
		int qtde = 0;
		try {
			idProduto = Integer.parseInt(request.getParameter("qtde"));
		} catch (NumberFormatException e) {
		}
		
		if ( qtde > 0 ){
			try{
				pv.setProduto(produto);
				pv.setQtde(qtde);
				pv.setVenda(venda);
				
				pvDao.create(pv);
				
				HttpSession session = request.getSession();
				session.setAttribute("produtos", pvDao.list(idVenda));
				session.setAttribute("venda", vendaDao.read(idVenda));
				session.setAttribute("cardapio", produtoDao.list());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Vendas/VendaEditar.jsp");
				dispatcher.forward(request,response);
			}
			catch (Exception e){
			}
		}
	}
}
