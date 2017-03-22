package model;

public class ProdutoVenda {
	
	private Produto produto;
	private Venda venda;
	private int qtde;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public int getQtde() {
		return qtde;
	}
	
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
	@Override
	public String toString(){
		return	"Venda: "			+ venda.getId() +
				"; Quantidade: "	+ qtde +
				"; Produto: "		+ produto.getDescricao();
	}

}
