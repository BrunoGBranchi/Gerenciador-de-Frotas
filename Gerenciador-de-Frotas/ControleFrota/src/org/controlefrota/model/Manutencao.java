package org.controlefrota.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Manutencao  implements Serializable{

	private static final long serialVersionUID = -438531982840090109L;
	public static Integer nextcodigo = 0;
	private Integer	  codigo;
	private String    descricao;
	private String    tipo;
	private String    marca;
	private String    aplicacao;
	private Date datacad;  
	
	public Integer getnextcodigo() {
		nextcodigo += 1;
		return nextcodigo;
	}

	public static Integer getNextcodigo() {
		return nextcodigo;
	}

	public static void setNextcodigo(Integer nextcodigo) {
		Manutencao.nextcodigo = nextcodigo;
	}

	public Integer getcodigo() {
		return codigo;
	}

	public void setcodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getdescricao() {
		return descricao;
	}

	public void setdescricao(String descricao) {
		this.descricao = descricao;
	}

	public String gettipo() {
		return tipo;
	}

	public void settipo(String tipo) {
		this.tipo = tipo;
	}

	public String getmarca() {
		return marca;
	}

	public void setmarca(String marca) {
		this.marca = marca;
	}

	public String getaplicacao() {
		return aplicacao;
	}

	public void setaplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Date getdatacad() {
		return datacad;
	}

	public void setdatacad(Date datacad) {
		this.datacad = datacad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aplicacao == null) ? 0 : aplicacao.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((datacad == null) ? 0 : datacad.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		if (aplicacao == null) {
			if (other.aplicacao != null)
				return false;
		} else if (!aplicacao.equals(other.aplicacao))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (datacad == null) {
			if (other.datacad != null)
				return false;
		} else if (!datacad.equals(other.datacad))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manutencao [codigo=" + codigo + ", descricao=" + descricao + ", tipo="
				+ tipo + ", marca=" + marca + ", aplicacao=" + aplicacao + ", datacad="
				+ datacad + "]";
	}

	public Manutencao(Integer codigo, String descricao, String tipo, String marca,
			String aplicacao, Date datacad) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.marca = marca;
		this.aplicacao = aplicacao;
		this.datacad = datacad;
	}

	public Manutencao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
