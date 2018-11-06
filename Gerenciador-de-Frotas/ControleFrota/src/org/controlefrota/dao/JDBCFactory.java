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

	@Override
	public MovimentosDAO movimentosDao() {
		return new MovimentosJDBC();
	}

	@Override
	public FuncionarioDAO funcionariosDao() {
		return new FuncionarioJDBC();
	}

	@Override
	public ManutencaoDAO manutencaoDao() {
		return new ManutencaoJDBC();
	}

	@Override
	public VeiculosDAO veiculosDao() {
		return new VeiculoJDBC();
	}

}
