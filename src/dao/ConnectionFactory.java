package dao;

// Código de exemplo fornecido pelo prof. Bonato, ligeiramente modificado para tornar mais flexível.
// TODO: Fazer puxar de um arquivo .ini os parâmetros, igual eu fiz no projeto do primeiro semestre.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	// Parâmetros. É, a porra toda é static mesmo. E essa tabelinha toda bonitinha, vão falar que é viadagem.
	static String driver	= "mysql"		;
	static String servidor	= "localhost"	;
	static String schema	= "sive"		;
	static String usuario	= "alunos"		;
	static String senha		= "alunos"		;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtém conexão com o banco de dados
	public static Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:" + driver + "://" + servidor + "/" + schema + "?user=" + usuario + "&password=" + senha);
	}

}
