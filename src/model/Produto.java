package model;

public class Produto {

	private int id, qtde;
	private double precoCusto, precoVenda;
	private String nome, descricao, imagemURL;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQtde() {
		return qtde;
	}
	
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
	public double getPrecoCusto() {
		return precoCusto;
	}
	
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	public double getPrecoVenda() {
		return precoVenda;
	}
	
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagemURL() {
		return imagemURL;
	}

	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
	}

	@Override
	public String toString() {
		return	"Código do produto: "		+ id +
				"; Quantidade em estoque: " + qtde +
				", Preço de custo: R$ "		+ precoCusto +
				"; Preço de venda: R$ "		+ precoVenda +
				"; Nome do produto: "		+ nome +
				"; Descrição do produto: "	+ descricao +
				"; URL da imagem: "			+ imagemURL;
	}

}
