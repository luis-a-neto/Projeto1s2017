package model;

public class Usuario {

	private String login, senha, acesso;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}
	
	@Override
	public String toString() {
		return	"Login: "				+ login +
				"; Senha: "				+ senha +
				"; Nível de acesso: "	+ acesso;
	}
	
}
