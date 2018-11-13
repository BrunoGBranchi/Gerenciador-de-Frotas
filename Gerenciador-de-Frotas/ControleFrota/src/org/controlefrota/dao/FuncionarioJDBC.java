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
			statement.setString(1, dado.getnome());
			statement.setString(2, dado.getcpf());
			statement.setString(3, dado.getrg());
			statement.setString(4, dado.getctps());
			statement.setString(5, dado.getdtnasc());
			statement.setString(6, dado.getendereco());
			statement.setString(7, dado.getendnumero());
			statement.setString(8, dado.getbairro());
			statement.setString(9, dado.getcep());
			statement.setString(10, dado.getmunicipio());
			statement.setString(11, dado.getuf());
			statement.setString(12, dado.getcargo());
			statement.setDouble(13, dado.getsalario());
			statement.setDate(14, java.sql.Date.valueOf(dado.getdtadmissao()));
			statement.setString(15, dado.getcargahoraria());
			statement.setString(16, dado.getbanco());
			statement.setString(17, dado.getagencia());
			statement.setString(18, dado.getconta());
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

			statement.setString(1, dado.getnome());
			statement.setString(2, dado.getcpf());
			statement.setString(3, dado.getrg());
			statement.setString(4, dado.getctps());
			statement.setString(5, dado.getdtnasc());
			statement.setString(6, dado.getendereco());
			statement.setString(7, dado.getendnumero());
			statement.setString(8, dado.getbairro());
			statement.setString(9, dado.getcep());
			statement.setString(10, dado.getmunicipio());
			statement.setString(11, dado.getuf());
			statement.setString(12, dado.getcargo());
			statement.setDouble(13, dado.getsalario());
			statement.setDate(14, java.sql.Date.valueOf(dado.getdtadmissao()));
			statement.setString(15, dado.getcargahoraria());
			statement.setString(16, dado.getbanco());
			statement.setString(17, dado.getagencia());
			statement.setString(18, dado.getconta());
			statement.setDate(19, java.sql.Date.valueOf(dado.getdatacad()));
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
			statement.setInt(1, dado.getcodigo());
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
				funcionario.setnome(rs.getString("nome"));
				funcionario.setcpf(rs.getString("CPF"));
				funcionario.setrg(rs.getString("RG"));
				funcionario.setctps(rs.getString("CTPS"));
				funcionario.setdtnasc(rs.getString("DTNASC"));
				funcionario.setendereco(rs.getString("endereco"));
				funcionario.setendnumero(rs.getString("endnumero"));
				funcionario.setbairro(rs.getString("bairro"));
				funcionario.setcep(rs.getString("cep"));
				funcionario.setendnumero(rs.getString("endnumero"));
				funcionario.setmunicipio(rs.getString("municipio"));
				funcionario.setuf(rs.getString("uf"));
				funcionario.setcargo(rs.getString("cargo"));
				funcionario.setsalario(rs.getDouble("salario"));
				funcionario.setdtadmissao(rs.getDate("dtadmissao").toLocalDate());
				funcionario.setcargahoraria(rs.getString("cargaHoraria"));
				funcionario.setbanco(rs.getString("banco"));
				funcionario.setagencia(rs.getString("agencia"));
				funcionario.setconta(rs.getString("conta"));
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
