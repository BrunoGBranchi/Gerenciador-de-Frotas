package org.controlefrota.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.model.Funcionarios;

public class FuncionarioJDBC implements FuncionarioDAO {
	@Override
	public void inserir(Funcionarios dado) {
		try {
			String sql = "insert into funcionarios "
+ "(nome, CPF, RG, CTPS, DTNASC, endereco, endnumero, bairro, cep, municipio, uf, cargo, salario, dtadmissao, cargahoraria, banco, agencia, conta)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setString(2, dado.getCpf());
			statement.setString(3, dado.getRg());
			statement.setString(4, dado.getCtps());
			statement.setString(5, dado.getDtnasc());
			statement.setString(6, dado.getEndereco());
			statement.setString(7, dado.getEndnumero());
			statement.setString(8, dado.getBairro());
			statement.setString(9, dado.getCep());
			statement.setString(10, dado.getMunicipio());
			statement.setString(11, dado.getUf());
			statement.setString(12, dado.getCargo());
			statement.setDouble(13, dado.getSalario());
			statement.setDate(14, java.sql.Date.valueOf(dado.getDtadmissao()));
			statement.setString(15, dado.getCargahoraria());
			statement.setString(16, dado.getBairro());
			statement.setString(17, dado.getAgencia());
			statement.setString(18, dado.getConta());
			//statement.setDate(19, java.sql.Date.valueOf(dado.getdatacad()));
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Funcionarios dado) {
		try {
			String sql = "update funcionarios set nome = ?,CPF =?, RG = ?,CTPS = ?,DTNASC = ?"
					+ "endereco = ?, endnumero = ?,bairro = ?, cep = ?, municipio = ?,uf = ?"
					+ "cargo =?, salario = ?, dtadmissao = ?,cargahoraria = ?,banco = ?, agencia =?"
					+ "conta = ? ,datacad = ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setString(1, dado.getNome());
			statement.setString(2, dado.getCpf());
			statement.setString(3, dado.getRg());
			statement.setString(4, dado.getCtps());
			statement.setString(5, dado.getDtnasc());
			statement.setString(6, dado.getEndereco());
			statement.setString(7, dado.getEndnumero());
			statement.setString(8, dado.getBairro());
			statement.setString(9, dado.getCep());
			statement.setString(10, dado.getMunicipio());
			statement.setString(11, dado.getUf());
			statement.setString(12, dado.getCargo());
			statement.setDouble(13, dado.getSalario());
			statement.setDate(14, java.sql.Date.valueOf(dado.getDtadmissao()));
			statement.setString(15, dado.getCargahoraria());
			statement.setString(16, dado.getBairro());
			statement.setString(17, dado.getAgencia());
			statement.setString(18, dado.getConta());
			statement.setDate(19, java.sql.Date.valueOf(dado.getDatacad()));
			statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Funcionarios dado) {
		try {
			String sql = "delete from funcionarios where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void tabelas(Funcionarios dado) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Funcionarios> listar() {
		List<Funcionarios> func = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from funcionarios");
			while (rs.next()) {
				Funcionarios funcionario = new Funcionarios();
				funcionario.setCodigo(rs.getInt("codigo"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("CPF"));
				funcionario.setRg(rs.getString("RG"));
				funcionario.setCtps(rs.getString("CTPS"));
				funcionario.setDtnasc(rs.getString("DTNASC"));
				funcionario.setEndereco(rs.getString("endereco"));
				funcionario.setEndnumero(rs.getString("endnumero"));
				funcionario.setBairro(rs.getString("bairro"));
				funcionario.setCep(rs.getString("cep"));
				funcionario.setMunicipio(rs.getString("municipio"));
				funcionario.setUf(rs.getString("uf"));
				funcionario.setCargo(rs.getString("cargo"));
				funcionario.setSalario(rs.getDouble("salario"));
				funcionario.setDtadmissao(rs.getDate("dtadmissao").toLocalDate());
				funcionario.setCargahoraria(rs.getString("cargaHoraria"));
				funcionario.setBanco(rs.getString("banco"));
				funcionario.setAgencia(rs.getString("agencia"));
				funcionario.setConta(rs.getString("conta"));
				//funcionario.setdatacad(rs.getDate("datacad").toLocalDate());
				func.add(funcionario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return func;
	}

	@Override
	public Integer comparaigual(Funcionarios dado) {
		// TODO Auto-generated method stub
		return null;
	}

}
