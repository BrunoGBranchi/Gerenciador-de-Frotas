package org.controlefrota.dao;

public class JDBCFactory implements DaoFactory{

	@Override
	public UsuariosDAO usuariosDao() {
		return new UsuariosJDBC();
	}
	
	@Override
	public EmpresaDAO empresaDao() {
		return new EmpresaJDBC();
	}

}
