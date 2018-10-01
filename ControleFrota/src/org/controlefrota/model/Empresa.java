package org.controlefrota.model;

import java.io.Serializable;

public class Empresa  implements Serializable{
	
	private static final long serialVersionUID = 3751261266164180335L;
	private static Integer nextcodigo = 0;
	private Integer codigo;
	private String  razaoSocial;
	private String  nomeFantasia;
	private String  cnpj;
	private String  endereco;
	private String  numero;
	private String  bairro;
	private String  cep;
	private String  muni_codigo;
	private String  muni_uf;
	
	
	public static Integer getNextcodigo(){
		nextcodigo += 1;
		return nextcodigo;
		}
	
	
	public Integer getcodigo() {
		return codigo;
	}


	public void setcodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getrazaoSocial() {
		return razaoSocial;
	}


	public void setrazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public String getnomeFantasia() {
		return nomeFantasia;
	}


	public void setnomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getcnpj() {
		return cnpj;
	}


	public void setcnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getendereco() {
		return endereco;
	}


	public void setendereco(String endereco) {
		this.endereco = endereco;
	}


	public String getnumero() {
		return numero;
	}


	public void setnumero(String numero) {
		this.numero = numero;
	}


	public String getbairro() {
		return bairro;
	}


	public void setbairro(String bairro) {
		this.bairro = bairro;
	}


	public String getcep() {
		return cep;
	}


	public void setcep(String cep) {
		this.cep = cep;
	}


	public String getmuni_codigo() {
		return muni_codigo;
	}


	public void setmuni_codigo(String muni_codigo) {
		this.muni_codigo = muni_codigo;
	}


	public String getmuni_uf() {
		return muni_uf;
	}


	public void setmuni_uf(String muni_uf) {
		this.muni_uf = muni_uf;
	}


	public static void setNextcodigo(Integer nextcodigo) {
		Empresa.nextcodigo = nextcodigo;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (muni_codigo == null) {
			if (other.muni_codigo != null)
				return false;
		} else if (!muni_codigo.equals(other.muni_codigo))
			return false;
		if (muni_uf == null) {
			if (other.muni_uf != null)
				return false;
		} else if (!muni_uf.equals(other.muni_uf))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((muni_codigo == null) ? 0 : muni_codigo.hashCode());
		result = prime * result + ((muni_uf == null) ? 0 : muni_uf.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "Empresa [codigo=" + codigo + ", razaoSocial=" + razaoSocial + ", nomeFantasia="
				+ nomeFantasia + ", cnpj=" + cnpj + ", endereco=" + endereco + ", numero="
				+ numero + ", bairro=" + bairro + ", cep=" + cep + ", muni_codigo="
				+ muni_codigo + ", muni_uf=" + muni_uf + "]";
	}
	public Empresa(Integer codigo, String razaoSocial, String nomeFantasia, String cnpj,
			String endereco, String numero, String bairro, String cep, String muni_codigo,
			String muni_uf) {
		super();
		this.codigo = codigo;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.muni_codigo = muni_codigo;
		this.muni_uf = muni_uf;
	}
	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
