package org.controlefrota.dao;

public interface DaoFactory {

	UsuariosDAO usuariosDao();
	
	EmpresaDAO empresaDao();
}
