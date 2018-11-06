package org.controlefrota.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.model.Movimentos;

public class MovimentosJDBC implements MovimentosDAO {

	@Override
	public void inserir(Movimentos dado) {
		try {
			String sql = "insert into movimentos values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setString(1, dado.getobservacao());
			statement.setString(2, dado.getvalor());
			statement.setInt(3, dado.getcodigo());
			statement.setInt(4, dado.getcodmanutencao());
			statement.setInt(5, dado.getcodigo());
			statement.setInt(6, dado.getnumeronota());
			statement.setInt(7, dado.getveic_codigo());
			statement.setInt(8, dado.getveickm());
			statement.setDate(9, java.sql.Date.valueOf(dado.getdatamvto()));
			statement.setDate(10, java.sql.Date.valueOf(dado.getdataemissnota()));
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Movimentos dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Movimentos dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tabelas(Movimentos dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Movimentos> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer comparaigual(Movimentos dado) {
		// TODO Auto-generated method stub
		return null;
	}

}
