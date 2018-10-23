package org.controlefrota.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.model.t_Veiculos;

public class VeiculoJDBC implements VeiculosDAO {

	@Override
	public void inserir(t_Veiculos dado) {
		try {
			String sql = "insert into veiculos values(?,?,?,?,?,?)";
		PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
		
		statement.setString(1, dado.getmarca());
		statement.setString(2, dado.getmodelo());
		statement.setString(3, dado.getplaca());
		statement.setString(4, dado.getmotor());
		statement.setString(5, dado.getchassi());
		statement.setString(6, dado.getcategoria());
		statement.executeUpdate();		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(t_Veiculos dado) {
		try {
			String sql = "update veiculos set marca = ?, modelo = ?,placa = ?,motor = ?,"
					+ "chassi = ?,categoria = ? where renavam = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			
			statement.setString(1, dado.getmarca());
			statement.setString(2, dado.getmodelo());
			statement.setString(3, dado.getplaca());
			statement.setString(4, dado.getmotor());
			statement.setString(5, dado.getchassi());
			statement.setString(6, dado.getcategoria());
			statement.executeUpdate();		
				
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(t_Veiculos dado) {
		try {
			String sql = "delete from veiculos where renavam = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			
			statement.setInt(1,dado.getrenavam());
			statement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	@Override
	public void tabelas(t_Veiculos dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logar(t_Veiculos dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<t_Veiculos> listar() {
		List<t_Veiculos> vec = new ArrayList<>();
		try {
		Statement state = ConexaoUtil.getConn().createStatement();
		ResultSet rs = state.executeQuery("select*from veiculos");
		while(rs.next()) {
		t_Veiculos veiculo = new t_Veiculos();
		veiculo.setmarca(rs.getString("marca"));
		veiculo.setmodelo(rs.getString("modelo"));
		veiculo.setplaca(rs.getString("placa"));
		veiculo.setmotor(rs.getString("motor"));
		veiculo.setchassi(rs.getString("chassi"));
		veiculo.setcategoria(rs.getString("categoria"));
		vec.add(veiculo);
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vec;
	}

	@Override
	public Integer comparaigual(t_Veiculos dado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
