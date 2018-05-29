package org.controlefrota.dao;

import org.controlefrota.model.Manutencao;

public class ManutencaoArquivo extends CrudArquivo<Manutencao> implements ManutencaoDAO {

	@Override
	protected ManipuladorArquivo<Manutencao> criarManipulador() {
		return new ManipuladorArquivo<>("manutencao.db");
	}

}