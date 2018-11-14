package org.controlefrota.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.model.Veiculos;

public class VeiculoJDBC implements VeiculosDAO {

	@Override
	public void inserir(Veiculos dado) {
		try {
			String sql = "insert into veiculos (renavam, marca, modelo, placa, motor, chassi, categoria, datacad) values(?,?,?,?,?,?,?,?)";
		PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
		
		statement.setInt(1, dado.getRenavam());
		statement.setString(2, dado.getMarca());
		statement.setString(3, dado.getModelo());
		statement.setString(4, dado.getPlaca());
		statement.setString(5, dado.getMotor());
		statement.setString(6, dado.getChassi());
		statement.setString(7, dado.getCategoria().toString());
		statement.setDate(8, (dado.getDatacad()));
		statement.executeUpdate();		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Veiculos dado) {
		try {
			String sql = "update veiculos set renavam=?, marca=?, modelo=?, placa=?, motor=?, chassi=?, categoria=?,  where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			
			statement.setInt(1, dado.getRenavam());
			statement.setString(2, dado.getMarca());
			statement.setString(3, dado.getModelo());
			statement.setString(4, dado.getPlaca());
			statement.setString(5, dado.getMotor());
			statement.setString(6, dado.getChassi());
			statement.setString(7, dado.getCategoria().toString());
			statement.setInt(8, dado.getCodigo());
			statement.executeUpdate();		
				
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Veiculos dado) {
		try {
			String sql = "delete from veiculos where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			
			statement.setInt(1,dado.getCodigo());
			statement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	@Override
	public void tabelas(Veiculos dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Veiculos> listar() {
		List<Veiculos> vec = new ArrayList<>();
		try {
		Statement state = ConexaoUtil.getConn().createStatement();
		ResultSet rs = state.executeQuery("select * from veiculos");
		while(rs.next()) {
		Veiculos veiculo = new Veiculos();
		veiculo.setCodigo(rs.getInt("codigo"));
		veiculo.setRenavam(rs.getInt("renavam"));
		veiculo.setMarca(rs.getString("marca"));
		veiculo.setModelo(rs.getString("modelo"));
		veiculo.setPlaca(rs.getString("placa"));
		veiculo.setMotor(rs.getString("motor"));
		veiculo.setChassi(rs.getString("chassi"));
		veiculo.setCategoria(rs.getString("categoria"));
		veiculo.setDatacad(rs.getDate("datacad"));
		vec.add(veiculo);
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vec;
	}

	@Override
	public Integer comparaigual(Veiculos dado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
