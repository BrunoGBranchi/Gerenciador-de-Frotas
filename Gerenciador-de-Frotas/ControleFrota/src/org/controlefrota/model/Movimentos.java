package org.controlefrota.model;


import java.io.Serializable;
import java.sql.Date;
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

public class Movimentos implements Serializable{

	
	private static final long serialVersionUID = -262038540164446134L;
	private Integer codigo;
	private Integer numeronota;
	private Date dataemissnota;
    private Date datamvto;
	private Integer veickm;
	private Double  valor;
	private String  observacao;
	private Veiculos veiculo;
	private Manutencao manutencao;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getNumeronota() {
		return numeronota;
	}
	public void setNumeronota(Integer numeronota) {
		this.numeronota = numeronota;
	}
	public Date getDataemissnota() {
		return dataemissnota;
	}
	public void setDataemissnota(Date dataemissnota) {
		this.dataemissnota = dataemissnota;
	}
	public Date getDatamvto() {
		return datamvto;
	}
	public void setDatamvto(Date datamvto) {
		this.datamvto = datamvto;
	}
	public Integer getVeickm() {
		return veickm;
	}
	public void setVeickm(Integer veickm) {
		this.veickm = veickm;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Veiculos getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}
	public Manutencao getManutencao() {
		return manutencao;
	}
	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Movimentos [codigo=" + codigo + ", numeronota=" + numeronota + ", dataemissnota=" + dataemissnota
				+ ", datamvto=" + datamvto + ", veickm=" + veickm 
				 + ", valor=" + valor + ", observacao=" + observacao + ", veiculo=" + veiculo
				+ ", manutencao=" + manutencao + "]";
	}
	public Movimentos(Integer codigo, Integer numeronota, Date dataemissnota, Date datamvto, Integer veickm,
			Double valor, String observacao, Veiculos veiculo, Manutencao manutencao) {
		super();
		this.codigo = codigo;
		this.numeronota = numeronota;
		this.dataemissnota = dataemissnota;
		this.datamvto = datamvto;
		this.veickm = veickm;
		this.valor = valor;
		this.observacao = observacao;
		this.veiculo = veiculo;
		this.manutencao = manutencao;
	}
	public Movimentos() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	
}
