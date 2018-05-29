package org.controlefrota.dao;

import org.controlefrota.model.Movimentos;

public class MovimentosArquivo extends CrudArquivo<Movimentos> implements MovimentosDAO {

	@Override
	protected ManipuladorArquivo<Movimentos> criarManipulador() {
		return new ManipuladorArquivo<>("movimentos.db");
	}

}