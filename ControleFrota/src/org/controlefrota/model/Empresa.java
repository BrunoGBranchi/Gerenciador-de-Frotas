package org.controlefrota.model;

import java.io.Serializable;

public class Empresa  implements Serializable{
	
	private static final long serialVersionUID = 3751261266164180335L;
	private static Integer nextEmpr_codigo = 0;
	private Integer empr_codigo;
	private String  empr_razaoSocial;
	private String  empr_nomeFantasia;
	private String  empr_cnpj;
	private String  empr_endereco;
	private String  empr_numero;
	private String  empr_bairro;
	private String  empr_cep;
	private String  empr_muni_codigo;
	private String  empr_muni_uf;
	
	
	public static Integer getNextEmpr_codigo(){
		nextEmpr_codigo += 1;
		return nextEmpr_codigo;
		}
	
	
	public Integer getEmpr_codigo() {
		return empr_codigo;
	}


	public void setEmpr_codigo(Integer empr_codigo) {
		this.empr_codigo = empr_codigo;
	}


	public String getEmpr_razaoSocial() {
		return empr_razaoSocial;
	}


	public void setEmpr_razaoSocial(String empr_razaoSocial) {
		this.empr_razaoSocial = empr_razaoSocial;
	}


	public String getEmpr_nomeFantasia() {
		return empr_nomeFantasia;
	}


	public void setEmpr_nomeFantasia(String empr_nomeFantasia) {
		this.empr_nomeFantasia = empr_nomeFantasia;
	}


	public String getEmpr_cnpj() {
		return empr_cnpj;
	}


	public void setEmpr_cnpj(String empr_cnpj) {
		this.empr_cnpj = empr_cnpj;
	}


	public String getEmpr_endereco() {
		return empr_endereco;
	}


	public void setEmpr_endereco(String empr_endereco) {
		this.empr_endereco = empr_endereco;
	}


	public String getEmpr_numero() {
		return empr_numero;
	}


	public void setEmpr_numero(String empr_numero) {
		this.empr_numero = empr_numero;
	}


	public String getEmpr_bairro() {
		return empr_bairro;
	}


	public void setEmpr_bairro(String empr_bairro) {
		this.empr_bairro = empr_bairro;
	}


	public String getEmpr_cep() {
		return empr_cep;
	}


	public void setEmpr_cep(String empr_cep) {
		this.empr_cep = empr_cep;
	}


	public String getEmpr_muni_codigo() {
		return empr_muni_codigo;
	}


	public void setEmpr_muni_codigo(String empr_muni_codigo) {
		this.empr_muni_codigo = empr_muni_codigo;
	}


	public String getEmpr_muni_uf() {
		return empr_muni_uf;
	}


	public void setEmpr_muni_uf(String empr_muni_uf) {
		this.empr_muni_uf = empr_muni_uf;
	}


	public static void setNextEmpr_codigo(Integer nextEmpr_codigo) {
		Empresa.nextEmpr_codigo = nextEmpr_codigo;
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
		if (empr_bairro == null) {
			if (other.empr_bairro != null)
				return false;
		} else if (!empr_bairro.equals(other.empr_bairro))
			return false;
		if (empr_cep == null) {
			if (other.empr_cep != null)
				return false;
		} else if (!empr_cep.equals(other.empr_cep))
			return false;
		if (empr_cnpj == null) {
			if (other.empr_cnpj != null)
				return false;
		} else if (!empr_cnpj.equals(other.empr_cnpj))
			return false;
		if (empr_codigo == null) {
			if (other.empr_codigo != null)
				return false;
		} else if (!empr_codigo.equals(other.empr_codigo))
			return false;
		if (empr_endereco == null) {
			if (other.empr_endereco != null)
				return false;
		} else if (!empr_endereco.equals(other.empr_endereco))
			return false;
		if (empr_muni_codigo == null) {
			if (other.empr_muni_codigo != null)
				return false;
		} else if (!empr_muni_codigo.equals(other.empr_muni_codigo))
			return false;
		if (empr_muni_uf == null) {
			if (other.empr_muni_uf != null)
				return false;
		} else if (!empr_muni_uf.equals(other.empr_muni_uf))
			return false;
		if (empr_nomeFantasia == null) {
			if (other.empr_nomeFantasia != null)
				return false;
		} else if (!empr_nomeFantasia.equals(other.empr_nomeFantasia))
			return false;
		if (empr_numero == null) {
			if (other.empr_numero != null)
				return false;
		} else if (!empr_numero.equals(other.empr_numero))
			return false;
		if (empr_razaoSocial == null) {
			if (other.empr_razaoSocial != null)
				return false;
		} else if (!empr_razaoSocial.equals(other.empr_razaoSocial))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empr_bairro == null) ? 0 : empr_bairro.hashCode());
		result = prime * result + ((empr_cep == null) ? 0 : empr_cep.hashCode());
		result = prime * result + ((empr_cnpj == null) ? 0 : empr_cnpj.hashCode());
		result = prime * result + ((empr_codigo == null) ? 0 : empr_codigo.hashCode());
		result = prime * result + ((empr_endereco == null) ? 0 : empr_endereco.hashCode());
		result = prime * result + ((empr_muni_codigo == null) ? 0 : empr_muni_codigo.hashCode());
		result = prime * result + ((empr_muni_uf == null) ? 0 : empr_muni_uf.hashCode());
		result = prime * result + ((empr_nomeFantasia == null) ? 0 : empr_nomeFantasia.hashCode());
		result = prime * result + ((empr_numero == null) ? 0 : empr_numero.hashCode());
		result = prime * result + ((empr_razaoSocial == null) ? 0 : empr_razaoSocial.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "Empresa [empr_codigo=" + empr_codigo + ", empr_razaoSocial=" + empr_razaoSocial + ", empr_nomeFantasia="
				+ empr_nomeFantasia + ", empr_cnpj=" + empr_cnpj + ", empr_endereco=" + empr_endereco + ", empr_numero="
				+ empr_numero + ", empr_bairro=" + empr_bairro + ", empr_cep=" + empr_cep + ", empr_muni_codigo="
				+ empr_muni_codigo + ", empr_muni_uf=" + empr_muni_uf + "]";
	}
	public Empresa(Integer empr_codigo, String empr_razaoSocial, String empr_nomeFantasia, String empr_cnpj,
			String empr_endereco, String empr_numero, String empr_bairro, String empr_cep, String empr_muni_codigo,
			String empr_muni_uf) {
		super();
		this.empr_codigo = empr_codigo;
		this.empr_razaoSocial = empr_razaoSocial;
		this.empr_nomeFantasia = empr_nomeFantasia;
		this.empr_cnpj = empr_cnpj;
		this.empr_endereco = empr_endereco;
		this.empr_numero = empr_numero;
		this.empr_bairro = empr_bairro;
		this.empr_cep = empr_cep;
		this.empr_muni_codigo = empr_muni_codigo;
		this.empr_muni_uf = empr_muni_uf;
	}
	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
