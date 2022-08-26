package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
	private Connection con;
	private Cliente cliente;

	public ClienteDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj) {
		cliente = (Cliente) obj;
		String sql = "insert into cliente(idcliente, nomecliente, placa)";
		sql += " values(?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());
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
		cliente = (Cliente) obj;
		String sql = "update cliente set nomecliente = ?, placa = ?";
		sql += " where idcliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());
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
		cliente = (Cliente) obj;
		String sql = "delete from cliente";
		sql += " where idcliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso.";
			} else {
				return "Erro ao Deletar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String listarTodos() {
		String sql = "select * from cliente";
		String listaCliente = "Lista dos clientes\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCliente += "id cliente: " + rs.getInt(1) + "\n";
					listaCliente += "nome cliente: " + rs.getString(2) + "\n";
					listaCliente += "placa: " + rs.getString(3) + "\n";
				}
				return listaCliente;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return e.getMessage();
		}

	}
}
