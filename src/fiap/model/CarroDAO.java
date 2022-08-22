package fiap.model;
import java.sql.*;

public class CarroDAO implements IDAO {
	
	private Connection con;
	private Carro carro;
	
	
	public CarroDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj) {
		carro = (Carro) obj;
		String sql = "insert into carro(placa, cor, descricao)";
		sql += " values(?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getCor());
			ps.setString(3, carro.getDescricao());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterar(Object obj) {
	carro = (Carro) obj;
	String sql = "update carro set cor = ?, descricao = ?";
	sql += " where placa = ?";
	try {
		PreparedStatement ps = getCon().prepareStatement(sql);
		ps.setString(1, carro.getPlaca());
		ps.setString(2, carro.getCor());
		ps.setString(3, carro.getDescricao());
		if (ps.executeUpdate() > 0) {
			return "Alterado com sucesso.";
		} else {
			return "Erro ao Alterar.";
		}
	} catch (SQLException e) {
		return e.getMessage();
	}
}
	
	public String excluir(Object obj) {
		carro = (Carro) obj;
		String sql = "delete from carro";
		sql += " where placa = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String listarTodos() {
		String sql = "select * from carro";
		String listaCarro = "Lista dos Carros\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCarro += "Placa: " + rs.getString(1) + "\n";
					listaCarro += "cor: " + rs.getString(3) + "\n";
					listaCarro += "Descricao: " + rs.getString(2) + "\n";
				}
				return listaCarro;
			} else {
				return null;
			}
			

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


}
