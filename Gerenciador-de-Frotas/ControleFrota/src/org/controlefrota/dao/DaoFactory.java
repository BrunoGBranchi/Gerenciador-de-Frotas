package org.controlefrota.dao;

public interface DaoFactory {

	UsuariosDAO usuariosDao();
	
	EmpresaDAO empresaDao();
	
	MovimentosDAO movimentosDao();

	FuncionarioDAO funcionariosDao();

	ManutencaoDAO manutencaoDao();

	VeiculosDAO veiculosDao();
}
