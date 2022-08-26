package fiap.controller;

import java.sql.Connection;

import fiap.model.CarroDAO;
import fiap.model.Cliente;
import fiap.model.ClienteDAO;
import fiap.model.Conexao;

public class ClienteController {
	
	public String insereCliente(int idCliente, String nomeCliente, String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		ClienteDAO cd = new ClienteDAO(con);
		Cliente cb = new Cliente();
		cb.setIdCliente(idCliente);
		resultado = cd.inserir(cb);
		Conexao.fechaConexao(con);
		return resultado;
	}
	
	public String alteraCliente(int idCliente, String nomeCliente, String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		ClienteDAO cd = new ClienteDAO(con);
		Cliente cb = new Cliente();
		cb.setIdCliente(idCliente);
		resultado = cd.alterar(cb);
		Conexao.fechaConexao(con);
		return resultado;
	}
	
	public String excluir(int idCliente) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		ClienteDAO cd = new ClienteDAO(con);
		Cliente cb = new Cliente();
		cb.setIdCliente(idCliente);
		resultado = cd.excluir(cb);
		Conexao.fechaConexao(con);
		return resultado;
	}
	public String listaCarro() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		ClienteDAO cd = new ClienteDAO(con);
		resultado = cd.listarTodos();
		Conexao.fechaConexao(con);
		if (resultado != null)  {
			return resultado;
			
		} else {
			return null;
			
		}
	}

}
