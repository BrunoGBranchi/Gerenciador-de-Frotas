package org.controlefrota.dao;

import org.controlefrota.model.Usuarios;

public class UsuariosArquivo extends CrudArquivo<Usuarios> implements UsuariosDAO {

	@Override
	protected ManipuladorArquivo<Usuarios> criarManipulador() {
		return new ManipuladorArquivo<>("usuarios.db");
	}

}
