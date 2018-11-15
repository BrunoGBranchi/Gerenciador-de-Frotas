package org.controlefrota.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.model.Manutencao;
import org.controlefrota.model.Movimentos;
import org.controlefrota.model.Veiculos;

public class MovimentosJDBC implements MovimentosDAO {

	@Override
	public void inserir(Movimentos dado) {
		try {
			String sql = "insert into movimentos (observacao, valor, cod_manutencao, numeronota, veickm, datamvto, datanota, cod_veiculo) values (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setString(1, dado.getObservacao());
			statement.setDouble(2, dado.getValor());
			statement.setInt(3, dado.getManutencao().getCodigo());
			statement.setInt(4, dado.getNumeronota());
			statement.setInt(5, dado.getVeickm());
			statement.setDate(6, (dado.getDatamvto()));
			statement.setDate(7, (dado.getDataemissnota()));
			statement.setInt(8, dado.getVeiculo().getCodigo());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Movimentos dado) {
		try {
			String sql = "update movimentos set observacao=?, valor=?, cod_manutencao=?, numeronota=?, veickm=?, datamvto=?, datanota=?, cod_veiculo=? where codigo=?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getObservacao());
			statement.setDouble(2, dado.getValor());
			statement.setInt(3, dado.getManutencao().getCodigo());
			statement.setInt(4, dado.getNumeronota());
			statement.setInt(5, dado.getVeickm());
			statement.setDate(6, (dado.getDatamvto()));
			statement.setDate(7, (dado.getDataemissnota()));
			statement.setInt(8, dado.getVeiculo().getCodigo());
			statement.setInt(9, (dado.getCodigo()));
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Movimentos dado) {
		try {
			String sql = "delete from movimentos where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void tabelas(Movimentos dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Movimentos> listar() {
		List<Movimentos> movi = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from view_movimento_nome");
			while (rs.next()) {
				Movimentos movimento = new Movimentos();
				Veiculos veiculo = new Veiculos();
				Manutencao manutencao = new Manutencao();
				movimento.setCodigo(rs.getInt("codigo"));
				movimento.setObservacao(rs.getString("observacao"));
				movimento.setValor(rs.getDouble("valor"));
				movimento.setNumeronota(rs.getInt("NumNota"));
				movimento.setDataemissnota(rs.getDate("datanota"));
				movimento.setDatamvto(rs.getDate("datamvto"));
				movimento.setVeickm(rs.getInt("KM"));
				movimento.setQuantidade(rs.getDouble("quantidade"));
				veiculo.setCodigo(rs.getInt(("codVeic")));
				manutencao.setCodigo(rs.getInt("CodManu"));
				movimento.setVeiculo(veiculo);
				movimento.setManutencao(manutencao);
				movi.add(movimento);			
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movi;
	}

	@Override
	public Integer comparaigual(Movimentos dado) {
		// TODO Auto-generated method stub
		return null;
	}

}
