package org.controlefrota.dao;

import java.util.List;


public abstract class CrudArquivo<T> implements CrudDAO<T> {

	private ManipuladorArquivo<T> manipulador;

	public CrudArquivo(){
		manipulador = criarManipulador();
	}
	
	protected abstract ManipuladorArquivo<T> criarManipulador();
	
	@Override
	public void inserir(T dado) {
		List<T> dados = manipulador.recuperar();
		dados.add(dado);
		manipulador.gravar(dados);
	}

	
	@Override
	public void alterar(T parametro) {
		List<T> dadosbanco = manipulador.recuperar();
		List<T> dadosgravar = manipulador.recuperar();
		dadosgravar.removeAll(dadosbanco);
		for (Integer cc=0; cc<dadosbanco.size(); cc++) 
			{
			if (dadosbanco.get(cc).toString().equalsIgnoreCase(parametro.toString()))
				{
				dadosgravar.add(parametro);
				this.excluir(dadosbanco.get(cc));
				}
			else
			{
			dadosgravar.add((T) dadosbanco.get(cc));	
			}			
			}
		manipulador.gravar(dadosgravar);
	}

	@Override
	public void excluir(T dado) {
		List<T> dados = manipulador.recuperar();
		dados.remove(dado);
		manipulador.gravar(dados);
	}

	@Override
	public List<T> listar() {
		return manipulador.recuperar();
	}
	
	public Integer comparaigual(T parametro) {
		Integer achou=0;
		List<T> dadosbanco = manipulador.recuperar();
		if (dadosbanco.size()==0) {achou=2;}
		for (Integer cc=0; cc<dadosbanco.size(); cc++) 
			{
			if (dadosbanco.get(cc).toString().equalsIgnoreCase(parametro.toString()))
				{
				achou=1;
				}
			}
		return achou;
	}	
	
	public void tabelas(T dado){
		manipulador.criatabelas(null);
	}
	
}
