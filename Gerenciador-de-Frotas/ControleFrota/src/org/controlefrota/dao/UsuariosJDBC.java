package org.controlefrota.dao;

import java.sql.Connection;
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
			String sql = "insert into usuarios values (?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getnome());
			statement.setString(2, dado.getsenha());
			statement.setString(3, dado.getusuario());
			statement.setDate(4, dado.getdatacad());
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
			statement.setString(1, dado.getnome());
			statement.setInt(2, dado.getcodigo());
			statement.setString(3, dado.getsenha());
			statement.setString(4, dado.getusuario());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void excluir(Usuarios dado) {
		try {
			String sql = "delete from area where idarea = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getcodigo());
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
		List<Usuarios> usuarios = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from usuarios");
			while (rs.next()) {
				Usuarios usuario = new Usuarios();
				usuario.setnome(rs.getString("nome"));
				usuario.setcodigo(rs.getInt("codigo"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;

	}

	@Override
	public Integer comparaigual(Usuarios dado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void logar(Usuarios dado) {
		try {
			Connection connection = (Connection) ConexaoUtil.getConn();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select Login, Senha from usuario");
			rs.first();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}    
	}
}