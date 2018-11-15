package org.controlefrota.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.model.Manutencao;
import org.controlefrota.model.Veiculos;

public class ManutencaoJDBC implements ManutencaoDAO {

	@Override
	public void inserir(Manutencao dado) {
		try {
			String sql = "insert into manutencao (descricao, tipo, marca, aplicacao, valor, cod_veiculo, datacad) values(?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getDescricao());
			statement.setString(2, dado.getTipo());
			statement.setString(3, dado.getMarca());
			statement.setString(4, dado.getAplicacao());
			statement.setDouble(5, dado.getValor());
			statement.setString(6, dado.getVeiculo().getCodigo().toString());
			statement.setDate(7, (dado.getDatacad()));
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Manutencao dado) {
		try {
			String sql = "update manutencao set descricao = ?, tipo = ?, marca = ?, "
					+ "aplicacao = ?, valor=?, cod_veiculo=?, datacad = ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getDescricao());
			statement.setString(2, dado.getTipo());
			statement.setString(3, dado.getMarca());
			statement.setString(4, dado.getAplicacao());
			statement.setDouble(5, dado.getValor());
			statement.setString(6, dado.getVeiculo().getCodigo().toString());
			statement.setDate(7, (dado.getDatacad()));
			statement.setInt(8, dado.getCodigo());
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
			statement.setInt(1, dado.getCodigo());
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
			ResultSet rs = statement.executeQuery("select * from view_manutencao_nome");
			while (rs.next()) {
				Manutencao manutencao = new Manutencao();
				manutencao.setCodigo(rs.getInt("codigo"));
				manutencao.setDescricao(rs.getString("descricao"));
				manutencao.setTipo(rs.getString("tipo"));
				manutencao.setMarca(rs.getString("marca"));
				manutencao.setAplicacao(rs.getString("aplicacao"));
				manutencao.setDatacad(rs.getDate("datacad"));
				manutencao.setValor(rs.getDouble("valor"));
				Veiculos veiculo = new Veiculos();
				veiculo.setCodigo(rs.getInt(("codVeic")));
				veiculo.setModelo(rs.getString("nomeveiculo"));
				manutencao.setVeiculo(veiculo);
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
