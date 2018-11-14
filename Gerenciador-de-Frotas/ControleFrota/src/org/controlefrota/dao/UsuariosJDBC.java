package org.controlefrota.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.model.Usuarios;

public class UsuariosJDBC implements UsuariosDAO {

	@Override
	public void inserir(Usuarios dado) {
		try {
			String sql = "insert into usuarios (nome, usuario, senha, datacad) values (?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setString(3, dado.getSenha());
			statement.setString(2, dado.getUsuario());
			statement.setDate(4, dado.getDatacad());
			statement.executeUpdate();
			
			// Popular o objeto com o código gerado.
			// Somente nos caso de campo auto-incremento
			//ResultSet rs = statement.getGeneratedKeys();
			//rs.next();
			//dado.setCodigo(rs.getInt(1));
			//---->
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Usuarios dado) {
		try {
			String sql = "update usuarios set nome = ?, usuario = ?, senha = ? " 
						+ " where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setString(2, dado.getUsuario());
			statement.setString(3, dado.getSenha());
			statement.setInt(4, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void excluir(Usuarios dado) {
		try {
			String sql = "delete from usuarios where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void tabelas(Usuarios dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuarios> listar() {
		List<Usuarios> usua = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from usuarios");
			while (rs.next()) {
				Usuarios usuario = new Usuarios();
				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setDatacad(rs.getDate("datacad"));
				usua.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usua;

	}

	@Override
	public Integer comparaigual(Usuarios dado) {
		// TODO Auto-generated method stub
		return null;
	}

	}
