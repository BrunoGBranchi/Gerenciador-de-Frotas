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
			String sql = "insert into empresa (razaoSocial, nomeFantasia, CNPJ, endereco, numero, bairro, cep, municipio, uf) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getRazaoSocial());
			statement.setString(2, dado.getNomeFantasia());
			statement.setString(3, dado.getCnpj());
			statement.setString(4, dado.getEndereco());
			statement.setString(5, dado.getNumero());
			statement.setString(6, dado.getBairro());
			statement.setString(7, dado.getCep());
			statement.setString(8, dado.getMunicipio());
			statement.setString(9, dado.getUf().toString());
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Empresa dado) {
		try {
			String sql = "update  empresa set razaoSocial = ?,nomeFantasia = ?,cnpj = ?,"
					+ " endereco = ?, numero = ?, bairro = ?,cep = ?,municipio = ?,uf = ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getRazaoSocial());
			statement.setString(2, dado.getNomeFantasia());
			statement.setString(3, dado.getCnpj());
			statement.setString(4, dado.getEndereco());
			statement.setString(5, dado.getNumero());
			statement.setString(6, dado.getBairro());
			statement.setString(7, dado.getCep());
			statement.setString(8, dado.getMunicipio());
			statement.setString(9, dado.getUf().toString());
			statement.setInt(10, dado.getCodigo());
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Empresa dado) {
		try {
			String sql = "delete from empresa where codigo = ? ";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override
	public void tabelas(Empresa dado) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Empresa> listar() {
		List<Empresa> emp = new ArrayList();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from empresa");
			while (rs.next()) {
				Empresa empresa = new Empresa();

				empresa.setCodigo(rs.getInt("codigo"));
				empresa.setRazaoSocial(rs.getString("razaoSocial"));
				empresa.setNomeFantasia(rs.getString("nomeFantasia"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setEndereco(rs.getString("endereco"));
				empresa.setNumero(rs.getString("numero"));
				empresa.setBairro(rs.getString("bairro"));
				empresa.setCep(rs.getString("cep"));
				empresa.setMunicipio(rs.getString("municipio"));
				empresa.setUf(rs.getString("uf"));
				emp.add(empresa);
			}

		} catch (Exception e) {
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
