package org.controlefrota.dao;

import java.util.List;

import org.controlefrota.model.Usuarios;

public interface CrudDAO<T> {

	void inserir(T dado);

	void alterar(T dado);

	void excluir(T dado);
	
	void tabelas(T dado);
	
	List<T> listar();
   
	Integer comparaigual(T dado);

}
