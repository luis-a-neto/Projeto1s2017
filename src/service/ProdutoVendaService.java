package service;

import dao.ProdutoVendaDAO;
import model.ProdutoVenda;

public class ProdutoVendaService {

	ProdutoVendaDAO dao = new ProdutoVendaDAO();

	public int create(ProdutoVenda produtovenda){
		return dao.create(produtovenda);
	}
	
	public ProdutoVenda read(int id){
		return dao.read(id);
	}
	
	public void update(ProdutoVenda produtovenda){
		dao.update(produtovenda);
	}
	
	public void delete(int id){
		dao.delete(id);
	}

}
