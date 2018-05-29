package org.controlefrota.model;

import java.io.Serializable;
import java.time.LocalDate;



public class Funcionarios  implements Serializable{

	private static final long serialVersionUID = 269601728039247486L;

	private Integer   func_codigo;
	private String    func_nome;
	private String    func_cpf;
	private String    func_rg;
	private String    func_ctps;
	private String    func_dtnasc;
	private String    func_endereco;
	private String    func_endnumero;
	private String    func_bairro;
	private String    func_cep;
    private String    func_muni_codigo;
	private String    func_muni_uf;
	private String    func_cargo;
	private Double    func_salario;
	private LocalDate func_dtadmissao;
	private String    func_cargahoraria;
	private String    func_banco;
	private String    func_agencia;
	private String    func_conta;
	private LocalDate func_datacad;
	public Integer getFunc_codigo() {
		return func_codigo;
	}
	public void setFunc_codigo(Integer func_codigo) {
		this.func_codigo = func_codigo;
	}
	public String getFunc_nome() {
		return func_nome;
	}
	public void setFunc_nome(String func_nome) {
		this.func_nome = func_nome;
	}
	public String getFunc_cpf() {
		return func_cpf;
	}
	public void setFunc_cpf(String func_cpf) {
		this.func_cpf = func_cpf;
	}
	public String getFunc_rg() {
		return func_rg;
	}
	public void setFunc_rg(String func_rg) {
		this.func_rg = func_rg;
	}
	public String getFunc_ctps() {
		return func_ctps;
	}
	public void setFunc_ctps(String func_ctps) {
		this.func_ctps = func_ctps;
	}
	public String getFunc_dtnasc() {
		return func_dtnasc;
	}
	public void setFunc_dtnasc(String func_dtnasc) {
		this.func_dtnasc = func_dtnasc;
	}
	public String getFunc_endereco() {
		return func_endereco;
	}
	public void setFunc_endereco(String func_endereco) {
		this.func_endereco = func_endereco;
	}
	public String getFunc_endnumero() {
		return func_endnumero;
	}
	public void setFunc_endnumero(String func_endnumero) {
		this.func_endnumero = func_endnumero;
	}
	public String getFunc_bairro() {
		return func_bairro;
	}
	public void setFunc_bairro(String func_bairro) {
		this.func_bairro = func_bairro;
	}
	public String getFunc_cep() {
		return func_cep;
	}
	public void setFunc_cep(String func_cep) {
		this.func_cep = func_cep;
	}
	public String getFunc_muni_codigo() {
		return func_muni_codigo;
	}
	public void setFunc_muni_codigo(String func_muni_codigo) {
		this.func_muni_codigo = func_muni_codigo;
	}
	public String getFunc_muni_uf() {
		return func_muni_uf;
	}
	public void setFunc_muni_uf(String func_muni_uf) {
		this.func_muni_uf = func_muni_uf;
	}
	public String getFunc_cargo() {
		return func_cargo;
	}
	public void setFunc_cargo(String func_cargo) {
		this.func_cargo = func_cargo;
	}
	public Double getFunc_salario() {
		return func_salario;
	}
	public void setFunc_salario(Double func_salario) {
		this.func_salario = func_salario;
	}
	public LocalDate getFunc_dtadmissao() {
		return func_dtadmissao;
	}
	public void setFunc_dtadmissao(LocalDate func_dtadmissao) {
		this.func_dtadmissao = func_dtadmissao;
	}
	public String getFunc_cargahoraria() {
		return func_cargahoraria;
	}
	public void setFunc_cargahoraria(String func_cargahoraria) {
		this.func_cargahoraria = func_cargahoraria;
	}
	public String getFunc_banco() {
		return func_banco;
	}
	public void setFunc_banco(String func_banco) {
		this.func_banco = func_banco;
	}
	public String getFunc_agencia() {
		return func_agencia;
	}
	public void setFunc_agencia(String func_agencia) {
		this.func_agencia = func_agencia;
	}
	public String getFunc_conta() {
		return func_conta;
	}
	public void setFunc_conta(String func_conta) {
		this.func_conta = func_conta;
	}
	public LocalDate getFunc_datacad() {
		return func_datacad;
	}
	public void setFunc_datacad(LocalDate func_datacad) {
		this.func_datacad = func_datacad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((func_agencia == null) ? 0 : func_agencia.hashCode());
		result = prime * result + ((func_bairro == null) ? 0 : func_bairro.hashCode());
		result = prime * result + ((func_banco == null) ? 0 : func_banco.hashCode());
		result = prime * result + ((func_cargahoraria == null) ? 0 : func_cargahoraria.hashCode());
		result = prime * result + ((func_cargo == null) ? 0 : func_cargo.hashCode());
		result = prime * result + ((func_cep == null) ? 0 : func_cep.hashCode());
		result = prime * result + ((func_codigo == null) ? 0 : func_codigo.hashCode());
		result = prime * result + ((func_conta == null) ? 0 : func_conta.hashCode());
		result = prime * result + ((func_cpf == null) ? 0 : func_cpf.hashCode());
		result = prime * result + ((func_ctps == null) ? 0 : func_ctps.hashCode());
		result = prime * result + ((func_datacad == null) ? 0 : func_datacad.hashCode());
		result = prime * result + ((func_dtadmissao == null) ? 0 : func_dtadmissao.hashCode());
		result = prime * result + ((func_dtnasc == null) ? 0 : func_dtnasc.hashCode());
		result = prime * result + ((func_endereco == null) ? 0 : func_endereco.hashCode());
		result = prime * result + ((func_endnumero == null) ? 0 : func_endnumero.hashCode());
		result = prime * result + ((func_muni_codigo == null) ? 0 : func_muni_codigo.hashCode());
		result = prime * result + ((func_muni_uf == null) ? 0 : func_muni_uf.hashCode());
		result = prime * result + ((func_nome == null) ? 0 : func_nome.hashCode());
		result = prime * result + ((func_rg == null) ? 0 : func_rg.hashCode());
		result = prime * result + ((func_salario == null) ? 0 : func_salario.hashCode());
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
		Funcionarios other = (Funcionarios) obj;
		if (func_agencia == null) {
			if (other.func_agencia != null)
				return false;
		} else if (!func_agencia.equals(other.func_agencia))
			return false;
		if (func_bairro == null) {
			if (other.func_bairro != null)
				return false;
		} else if (!func_bairro.equals(other.func_bairro))
			return false;
		if (func_banco == null) {
			if (other.func_banco != null)
				return false;
		} else if (!func_banco.equals(other.func_banco))
			return false;
		if (func_cargahoraria == null) {
			if (other.func_cargahoraria != null)
				return false;
		} else if (!func_cargahoraria.equals(other.func_cargahoraria))
			return false;
		if (func_cargo == null) {
			if (other.func_cargo != null)
				return false;
		} else if (!func_cargo.equals(other.func_cargo))
			return false;
		if (func_cep == null) {
			if (other.func_cep != null)
				return false;
		} else if (!func_cep.equals(other.func_cep))
			return false;
		if (func_codigo == null) {
			if (other.func_codigo != null)
				return false;
		} else if (!func_codigo.equals(other.func_codigo))
			return false;
		if (func_conta == null) {
			if (other.func_conta != null)
				return false;
		} else if (!func_conta.equals(other.func_conta))
			return false;
		if (func_cpf == null) {
			if (other.func_cpf != null)
				return false;
		} else if (!func_cpf.equals(other.func_cpf))
			return false;
		if (func_ctps == null) {
			if (other.func_ctps != null)
				return false;
		} else if (!func_ctps.equals(other.func_ctps))
			return false;
		if (func_datacad == null) {
			if (other.func_datacad != null)
				return false;
		} else if (!func_datacad.equals(other.func_datacad))
			return false;
		if (func_dtadmissao == null) {
			if (other.func_dtadmissao != null)
				return false;
		} else if (!func_dtadmissao.equals(other.func_dtadmissao))
			return false;
		if (func_dtnasc == null) {
			if (other.func_dtnasc != null)
				return false;
		} else if (!func_dtnasc.equals(other.func_dtnasc))
			return false;
		if (func_endereco == null) {
			if (other.func_endereco != null)
				return false;
		} else if (!func_endereco.equals(other.func_endereco))
			return false;
		if (func_endnumero == null) {
			if (other.func_endnumero != null)
				return false;
		} else if (!func_endnumero.equals(other.func_endnumero))
			return false;
		if (func_muni_codigo == null) {
			if (other.func_muni_codigo != null)
				return false;
		} else if (!func_muni_codigo.equals(other.func_muni_codigo))
			return false;
		if (func_muni_uf == null) {
			if (other.func_muni_uf != null)
				return false;
		} else if (!func_muni_uf.equals(other.func_muni_uf))
			return false;
		if (func_nome == null) {
			if (other.func_nome != null)
				return false;
		} else if (!func_nome.equals(other.func_nome))
			return false;
		if (func_rg == null) {
			if (other.func_rg != null)
				return false;
		} else if (!func_rg.equals(other.func_rg))
			return false;
		if (func_salario == null) {
			if (other.func_salario != null)
				return false;
		} else if (!func_salario.equals(other.func_salario))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return func_cpf.toString();
//				return "Funcionarios [func_codigo=" + func_codigo + ", func_nome=" + func_nome + ", func_cpf=" + func_cpf
//				+ ", func_rg=" + func_rg + ", func_ctps=" + func_ctps + ", func_dtnasc=" + func_dtnasc
//				+ ", func_endereco=" + func_endereco + ", func_endnumero=" + func_endnumero + ", func_bairro="
//				+ func_bairro + ", func_cep=" + func_cep + ", func_muni_codigo=" + func_muni_codigo + ", func_muni_uf="
//				+ func_muni_uf + ", func_cargo=" + func_cargo + ", func_salario=" + func_salario + ", func_dtadmissao="
//				+ func_dtadmissao + ", func_cargahoraria=" + func_cargahoraria + ", func_banco=" + func_banco/
//				+ ", func_agencia=" + func_agencia + ", func_conta=" + func_conta + ", func_datacad=" + func_datacad
//				+ "]";
	}
	public Funcionarios(Integer func_codigo, String func_nome, String func_cpf, String func_rg, String func_ctps,
			String func_dtnasc, String func_endereco, String func_endnumero, String func_bairro, String func_cep,
			String func_muni_codigo, String func_muni_uf, String func_cargo, Double func_salario,
			LocalDate func_dtadmissao, String func_cargahoraria, String func_banco, String func_agencia,
			String func_conta, LocalDate func_datacad) {
		super();
		this.func_codigo = func_codigo;
		this.func_nome = func_nome;
		this.func_cpf = func_cpf;
		this.func_rg = func_rg;
		this.func_ctps = func_ctps;
		this.func_dtnasc = func_dtnasc;
		this.func_endereco = func_endereco;
		this.func_endnumero = func_endnumero;
		this.func_bairro = func_bairro;
		this.func_cep = func_cep;
		this.func_muni_codigo = func_muni_codigo;
		this.func_muni_uf = func_muni_uf;
		this.func_cargo = func_cargo;
		this.func_salario = func_salario;
		this.func_dtadmissao = func_dtadmissao;
		this.func_cargahoraria = func_cargahoraria;
		this.func_banco = func_banco;
		this.func_agencia = func_agencia;
		this.func_conta = func_conta;
		this.func_datacad = func_datacad;
	}
	public Funcionarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
