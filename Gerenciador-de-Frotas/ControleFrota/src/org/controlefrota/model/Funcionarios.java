package org.controlefrota.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="codigo")
@ToString(of={"codigo"})


/*LOMBOK QUE TAVA FAZENDO A BOSTA DE NÃO RENDERIZAR A TABELA, CRIA GET E SET MANUALMENTE (PELO ALT+SHIFT+S) BJS*/


public class Funcionarios  implements Serializable{

	private static final long serialVersionUID = 269601728039247486L;

	private Integer codigo;
	private String nome;
	private String cpf;
	private String rg;
	private String ctps;
	private String dtnasc;
	private String endereco;
	private String endnumero;
	private String bairro;
	private String cep;
    private String municipio;
	private String uf;
	private String cargo;
	private Double salario;
	private LocalDate dtadmissao;
	private String cargahoraria;
	private String banco;
	private String agencia;
	private String conta;
	private LocalDate datacad;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCtps() {
		return ctps;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	public String getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(String dtnasc) {
		this.dtnasc = dtnasc;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEndnumero() {
		return endnumero;
	}
	public void setEndnumero(String endnumero) {
		this.endnumero = endnumero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public LocalDate getDtadmissao() {
		return dtadmissao;
	}
	public void setDtadmissao(LocalDate dtadmissao) {
		this.dtadmissao = dtadmissao;
	}
	public String getCargahoraria() {
		return cargahoraria;
	}
	public void setCargahoraria(String cargahoraria) {
		this.cargahoraria = cargahoraria;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public LocalDate getDatacad() {
		return datacad;
	}
	public void setDatacad(LocalDate datacad) {
		this.datacad = datacad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((banco == null) ? 0 : banco.hashCode());
		result = prime * result + ((cargahoraria == null) ? 0 : cargahoraria.hashCode());
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((ctps == null) ? 0 : ctps.hashCode());
		result = prime * result + ((datacad == null) ? 0 : datacad.hashCode());
		result = prime * result + ((dtadmissao == null) ? 0 : dtadmissao.hashCode());
		result = prime * result + ((dtnasc == null) ? 0 : dtnasc.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((endnumero == null) ? 0 : endnumero.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
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
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (banco == null) {
			if (other.banco != null)
				return false;
		} else if (!banco.equals(other.banco))
			return false;
		if (cargahoraria == null) {
			if (other.cargahoraria != null)
				return false;
		} else if (!cargahoraria.equals(other.cargahoraria))
			return false;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (ctps == null) {
			if (other.ctps != null)
				return false;
		} else if (!ctps.equals(other.ctps))
			return false;
		if (datacad == null) {
			if (other.datacad != null)
				return false;
		} else if (!datacad.equals(other.datacad))
			return false;
		if (dtadmissao == null) {
			if (other.dtadmissao != null)
				return false;
		} else if (!dtadmissao.equals(other.dtadmissao))
			return false;
		if (dtnasc == null) {
			if (other.dtnasc != null)
				return false;
		} else if (!dtnasc.equals(other.dtnasc))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (endnumero == null) {
			if (other.endnumero != null)
				return false;
		} else if (!endnumero.equals(other.endnumero))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return cpf.toString();
//				return "Funcionarios [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf
//				+ ", rg=" + rg + ", ctps=" + ctps + ", dtnasc=" + dtnasc
//				+ ", endereco=" + endereco + ", endnumero=" + endnumero + ", bairro="
//				+ bairro + ", cep=" + cep + ", municipio=" + municipio + ", uf="
//				+ uf + ", cargo=" + cargo + ", salario=" + salario + ", dtadmissao="
//				+ dtadmissao + ", cargahoraria=" + cargahoraria + ", banco=" + banco/
//				+ ", agencia=" + agencia + ", conta=" + conta + ", datacad=" + datacad
//				+ "]";
	}
	public Funcionarios(Integer codigo, String nome, String cpf, String rg, String ctps,
			String dtnasc, String endereco, String endnumero, String bairro, String cep,
			String municipio, String uf, String cargo, Double salario,
			LocalDate dtadmissao, String cargahoraria, String banco, String agencia,
			String conta, LocalDate datacad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.ctps = ctps;
		this.dtnasc = dtnasc;
		this.endereco = endereco;
		this.endnumero = endnumero;
		this.bairro = bairro;
		this.cep = cep;
		this.municipio = municipio;
		this.uf = uf;
		this.cargo = cargo;
		this.salario = salario;
		this.dtadmissao = dtadmissao;
		this.cargahoraria = cargahoraria;
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
		this.datacad = datacad;
	}
	public Funcionarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
