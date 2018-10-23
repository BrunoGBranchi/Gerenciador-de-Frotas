package org.controlefrota.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.model.Empresa;



public class EmpresaJDBC implements EmpresaDAO {

	@Override
	public void inserir(Empresa dado) {
		try {
		String sql =" insert into empresa values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
		statement.setString(1, dado.getrazaoSocial());
		statement.setString(2,dado.getnomeFantasia());
		statement.setString(3, dado.getcnpj());
		statement.setString(4, dado.getendereco());
		statement.setString(5, dado.getnumero());
		statement.setString(6, dado.getbairro());
		statement.setString(7,dado.getcep());
		statement.setString(8,dado.getmuni_codigo());
		statement.setString(9, dado.getmuni_uf());
		statement.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Empresa dado) {
		try {
			String sql = " update  empresa set razaoSocial = ?,nomeFantasia = ?,cnpj = ?"
					+ " endereco = ?, numero = ?, bairro = ?,cep = ?,muni_codigo = ?,muni_uf = ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getrazaoSocial());
			statement.setString(2,dado.getnomeFantasia());
			statement.setString(3, dado.getcnpj());
			statement.setString(4, dado.getendereco());
			statement.setString(5, dado.getnumero());
			statement.setString(6, dado.getbairro());
			statement.setString(7,dado.getcep());
			statement.setString(8,dado.getmuni_codigo());
			statement.setString(9, dado.getmuni_uf());
			statement.executeUpdate();
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Empresa dado) {
		try {
			String sql = "delete empresa from codigo = ? ";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			
			statement.setInt(1,dado.getcodigo());  
			statement.executeUpdate();
			
		}catch (Exception e) {
			
		e.printStackTrace();
		
		}
		
	}

	@Override
	public void tabelas(Empresa dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logar(Empresa dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empresa> listar() {
	List<Empresa> emp = new ArrayList();
	try {
		Statement statement = ConexaoUtil.getConn().createStatement();
		ResultSet rs = statement.executeQuery("select *from empresa");
		while(rs.next()) {
			Empresa empresa = new Empresa();
			
			empresa.setcodigo(rs.getInt("codigo"));
			empresa.setrazaoSocial(rs.getString("razaoSocial"));
			empresa.setnomeFantasia(rs.getString("nomeFantasia"));
			empresa.setcnpj(rs.getString("cnpj"));
			empresa.setendereco(rs.getString("endereco"));
			empresa.setnumero(rs.getString("numero"));
			empresa.setbairro(rs.getString("bairro"));
			empresa.setcep(rs.getString("cep"));
			empresa.setmuni_codigo(rs.getString("muni_codi"));
			empresa.setmuni_uf(rs.getString("muni_uf"));
			emp.add(empresa);
		}
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		return emp;
	}

	@Override
	public Integer comparaigual(Empresa dado) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
