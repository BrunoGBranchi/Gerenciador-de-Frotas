package org.controlefrota.dao;

import org.controlefrota.model.t_Veiculos;

public class VeiculosArquivo extends CrudArquivo<t_Veiculos> implements VeiculosDAO {

	@Override
	protected ManipuladorArquivo<t_Veiculos> criarManipulador() {
		return new ManipuladorArquivo<>("veiculos.db");
	}

}
