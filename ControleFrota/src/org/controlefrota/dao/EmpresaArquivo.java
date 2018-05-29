package org.controlefrota.dao;

import org.controlefrota.model.Empresa;

	public class EmpresaArquivo extends CrudArquivo<Empresa> implements EmpresaDAO {

		@Override
		protected ManipuladorArquivo<Empresa> criarManipulador() {
			return new ManipuladorArquivo<>("empresa.db");
		}

	}