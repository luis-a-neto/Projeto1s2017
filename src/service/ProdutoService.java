package service;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {

	ProdutoDAO dao = new ProdutoDAO();

	public int create(Produto produto){
		return dao.create(produto);
	}
	
	public Produto read(int id){
		return dao.read(id);
	}
	
	public void update(Produto produto){
		dao.update(produto);
	}
	
	public void delete(int id){
		dao.delete(id);
	}

}
