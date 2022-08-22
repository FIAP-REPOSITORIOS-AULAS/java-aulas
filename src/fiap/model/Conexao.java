package fiap.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection abrirConexao() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			
			final String USER = "rm93423";
			final String PASS = "260404";
			con = DriverManager.getConnection(url, USER, PASS);
			System.out.println("Conexão aberta.");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static void fechaConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexao Fechada.");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}  catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

}
