package org.controlefrota.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.model.Manutencao;

public class ManutencaoJDBC implements ManutencaoDAO {

	@Override
	public void inserir(Manutencao dado) {
		try {
			String sql = "insert into manutencao values(?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setString(1, dado.getdescricao());
			statement.setString(2, dado.gettipo());
			statement.setString(3, dado.getmarca());
			statement.setString(4, dado.getaplicacao());
			statement.setDate(5, (dado.getdatacad()));
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Manutencao dado) {
		try {
			String sql = "update manutencao set descricao = ?, tipo = ?, marca = ?, "
					+ "aplicacao = ?, datacad = ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getdescricao());
			statement.setString(2, dado.gettipo());
			statement.setString(3, dado.getmarca());
			statement.setString(4, dado.getaplicacao());
			statement.setDate(5, (dado.getdatacad()));
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Manutencao dado) {
		try {
			String sql = "delete from manutencao where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getcodigo());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void tabelas(Manutencao dado) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Manutencao> listar() {
		List<Manutencao> manu = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select*from manutencao");
			while (rs.next()) {
				Manutencao manutencao = new Manutencao();
				manutencao.setdescricao(rs.getString("descricao"));
				manutencao.settipo(rs.getString("tipo"));
				manutencao.setmarca(rs.getString("marca"));
				manutencao.setaplicacao(rs.getString("aplicacao"));
				manutencao.setdatacad(rs.getDate("datacad"));
				manu.add(manutencao);			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return manu;
	}

	@Override
	public Integer comparaigual(Manutencao dado) {
		// TODO Auto-generated method stub
		return null;
	}

}
