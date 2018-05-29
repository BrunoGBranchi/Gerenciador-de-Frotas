package org.controlefrota.dao;

import org.controlefrota.model.Funcionarios;

public class FuncionarioArquivo extends CrudArquivo<Funcionarios> implements FuncionarioDAO {

	@Override
	protected ManipuladorArquivo<Funcionarios> criarManipulador() {
		return new ManipuladorArquivo<>("funcionarios.db");
	}

}