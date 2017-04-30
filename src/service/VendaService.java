package service;

import java.util.ArrayList;

import dao.VendaDAO;
import model.Venda;

public class VendaService {

	VendaDAO dao = new VendaDAO();

	public int create(){
		return dao.create();
	}
	
	public Venda read(int id){
		return dao.read(id);
	}
	
	public void update(Venda venda){
		dao.update(venda);
	}
	
	public void delete(int id){
		dao.delete(id);
	}
	
	public ArrayList<Venda> list(int id){
		return dao.list();
	}

}

