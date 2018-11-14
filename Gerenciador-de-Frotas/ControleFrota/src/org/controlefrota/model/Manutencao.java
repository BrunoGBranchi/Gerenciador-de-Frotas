package org.controlefrota.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "codigo")
@ToString(of = { "codigo", "nome" })

public class Manutencao  implements Serializable{

	private static final long serialVersionUID = -438531982840090109L;
	private Integer codigo;
	private String descricao;
	private String tipo;
	private String marca;
	private Veiculos veiculo;
	private double valor;
	private String aplicacao;
	private Date datacad;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Veiculos getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getAplicacao() {
		return aplicacao;
	}
	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}
	public Date getDatacad() {
		return datacad;
	}
	public void setDatacad(Date datacad) {
		this.datacad = datacad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Manutencao [codigo=" + codigo + ", descricao=" + descricao + ", tipo=" + tipo + ", marca=" + marca
				+ ", veiculo=" + veiculo + ", valor=" + valor + ", aplicacao=" + aplicacao + ", datacad=" + datacad
				+ "]";
	}
	public Manutencao(Integer codigo, String descricao, String tipo, String marca, Veiculos veiculo, double valor,
			String aplicacao, Date datacad) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.marca = marca;
		this.veiculo = veiculo;
		this.valor = valor;
		this.aplicacao = aplicacao;
		this.datacad = datacad;
	}
	public Manutencao() {
		super();
		// TODO Auto-generated constructor stub
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
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}  

	 
	
}
