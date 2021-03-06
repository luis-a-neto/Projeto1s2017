package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdutoDAO;
import model.Produto;

public class CriarProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Produto produto = new Produto();
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		produto.setNome(request.getParameter("nome"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setImagemURL(request.getParameter("imagemURL"));
		
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
			produto.setQtde(0);
			produtoDao.create(produto);
			session.setAttribute("cardapio", produtoDao.list());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Produtos/ProdutoListar.jsp");
			dispatcher.forward(request,response);
		}
		catch (Exception e){
		}
	}
}
