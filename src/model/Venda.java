package model;

public class Venda {

	private int id;
	private double valorVenda;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getValorVenda() {
		return valorVenda;
	}
	
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	@Override
	public String toString() {
		return	"Código da venda: "		+ id +
				"; valor da venda: R$ " + valorVenda;
	}
	
}
