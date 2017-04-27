package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdutoDAO;
import model.Produto;

public class EditarProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Produto produto = new Produto();
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		produto.setNome(request.getParameter("nome"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setImagemURL(request.getParameter("imagemURL"));
		
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("Id"));
			produto.setId(id);
		} catch (NumberFormatException e) {
		}
		
		int qtde = -1;
		try {
			qtde = Integer.parseInt(request.getParameter("Qtde"));
			produto.setQtde(qtde);
		} catch (NumberFormatException e) {
		}
		
		double precoVenda = -1;
		try {
			precoVenda = Double.parseDouble(request.getParameter("precoVenda"));
			produto.setPrecoVenda(precoVenda);
		} catch (NumberFormatException e) {
		}
		
		double precoCusto = -1;
		try {
			precoCusto = Double.parseDouble(request.getParameter("precoCusto"));
			produto.setPrecoCusto(precoCusto);
		} catch (NumberFormatException e) {
		}
		
		try{
			HttpSession session = request.getSession();
			produtoDao.update(produto);
			session.setAttribute("cardapio", produtoDao.list());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Produtos/ProdutoListar.jsp");
			dispatcher.forward(request,response);
		}
		catch (Exception e){
		}
	}

}
