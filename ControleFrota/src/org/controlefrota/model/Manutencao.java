package org.controlefrota.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Manutencao  implements Serializable{

	private static final long serialVersionUID = -438531982840090109L;
	public static Integer nextManu_codigo = 0;
	private Integer	  manu_codigo;
	private String    manu_descricao;
	private String    manu_tipo;
	private String    manu_marca;
	private String    manu_aplicacao;
	private LocalDate manu_datacad;  
	
	public Integer getnextManu_codigo() {
		nextManu_codigo += 1;
		return nextManu_codigo;
	}

	public static Integer getNextManu_codigo() {
		return nextManu_codigo;
	}

	public static void setNextManu_codigo(Integer nextManu_codigo) {
		Manutencao.nextManu_codigo = nextManu_codigo;
	}

	public Integer getManu_codigo() {
		return manu_codigo;
	}

	public void setManu_codigo(Integer manu_codigo) {
		this.manu_codigo = manu_codigo;
	}

	public String getManu_descricao() {
		return manu_descricao;
	}

	public void setManu_descricao(String manu_descricao) {
		this.manu_descricao = manu_descricao;
	}

	public String getManu_tipo() {
		return manu_tipo;
	}

	public void setManu_tipo(String manu_tipo) {
		this.manu_tipo = manu_tipo;
	}

	public String getManu_marca() {
		return manu_marca;
	}

	public void setManu_marca(String manu_marca) {
		this.manu_marca = manu_marca;
	}

	public String getManu_aplicacao() {
		return manu_aplicacao;
	}

	public void setManu_aplicacao(String manu_aplicacao) {
		this.manu_aplicacao = manu_aplicacao;
	}

	public LocalDate getManu_datacad() {
		return manu_datacad;
	}

	public void setManu_datacad(LocalDate manu_datacad) {
		this.manu_datacad = manu_datacad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manu_aplicacao == null) ? 0 : manu_aplicacao.hashCode());
		result = prime * result + ((manu_codigo == null) ? 0 : manu_codigo.hashCode());
		result = prime * result + ((manu_datacad == null) ? 0 : manu_datacad.hashCode());
		result = prime * result + ((manu_descricao == null) ? 0 : manu_descricao.hashCode());
		result = prime * result + ((manu_marca == null) ? 0 : manu_marca.hashCode());
		result = prime * result + ((manu_tipo == null) ? 0 : manu_tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manutencao other = (Manutencao) obj;
		if (manu_aplicacao == null) {
			if (other.manu_aplicacao != null)
				return false;
		} else if (!manu_aplicacao.equals(other.manu_aplicacao))
			return false;
		if (manu_codigo == null) {
			if (other.manu_codigo != null)
				return false;
		} else if (!manu_codigo.equals(other.manu_codigo))
			return false;
		if (manu_datacad == null) {
			if (other.manu_datacad != null)
				return false;
		} else if (!manu_datacad.equals(other.manu_datacad))
			return false;
		if (manu_descricao == null) {
			if (other.manu_descricao != null)
				return false;
		} else if (!manu_descricao.equals(other.manu_descricao))
			return false;
		if (manu_marca == null) {
			if (other.manu_marca != null)
				return false;
		} else if (!manu_marca.equals(other.manu_marca))
			return false;
		if (manu_tipo == null) {
			if (other.manu_tipo != null)
				return false;
		} else if (!manu_tipo.equals(other.manu_tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manutencao [manu_codigo=" + manu_codigo + ", manu_descricao=" + manu_descricao + ", manu_tipo="
				+ manu_tipo + ", manu_marca=" + manu_marca + ", manu_aplicacao=" + manu_aplicacao + ", manu_datacad="
				+ manu_datacad + "]";
	}

	public Manutencao(Integer manu_codigo, String manu_descricao, String manu_tipo, String manu_marca,
			String manu_aplicacao, LocalDate manu_datacad) {
		super();
		this.manu_codigo = manu_codigo;
		this.manu_descricao = manu_descricao;
		this.manu_tipo = manu_tipo;
		this.manu_marca = manu_marca;
		this.manu_aplicacao = manu_aplicacao;
		this.manu_datacad = manu_datacad;
	}

	public Manutencao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
