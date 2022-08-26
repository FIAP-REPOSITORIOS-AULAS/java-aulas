package fiap.controller;

import java.sql.Connection;

import fiap.model.Carro;
import fiap.model.CarroDAO;
import fiap.model.Conexao;

public class CarroController {
	
	public String insereCarro(String placa, String cor, String descricao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		Carro cb = new Carro();
		cb.setPlaca(placa);
		resultado = cd.inserir(cb);
		Conexao.fechaConexao(con);
		return resultado;
	}
	
	public String alteraCarro(String placa, String cor, String descricao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		Carro cb = new Carro();
		cb.setPlaca(placa);
		resultado = cd.alterar(cb);
		Conexao.fechaConexao(con);
		return resultado;
	}
	public String exclui(String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		Carro cb = new Carro();
		cb.setPlaca(placa);
		resultado = cd.excluir(cb);
		Conexao.fechaConexao(con);
		return resultado;
	}
	public String listaCarro() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		resultado = cd.listarTodos();
		Conexao.fechaConexao(con);
		if (resultado != null)  {
			return resultado;
			
		} else {
			return null;
			
		}
	}


}
