package org.controlefrota.dao;

public class JDBCFactory implements DaoFactory{

	@Override
	public UsuariosDAO usuariosDao() {
		return new UsuariosJDBC();
	}

}
