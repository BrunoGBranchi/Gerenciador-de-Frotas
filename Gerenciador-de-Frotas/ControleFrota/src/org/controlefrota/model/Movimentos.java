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

	public Integer getcodigo() {
		return codigo;
	}
	public void setcodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getnumeronota() {
		return numeronota;
	}
	public void setnumeronota(Integer numeronota) {
		this.numeronota = numeronota;
	}
	public LocalDate getdataemissnota() {
		return dataemissnota;
	}
	public void setdataemissnota(LocalDate localDate) {
		this.dataemissnota = localDate;
	}
	public LocalDate getdatamvto() {
		return datamvto;
	}
	public void setdatamvto(LocalDate datamvto) {
		this.datamvto = datamvto;
	}
	public Integer getveic_codigo() {
		return veic_codigo;
	}
	public void setveic_codigo(Integer veic_codigo) {
		this.veic_codigo = veic_codigo;
	}
	public Integer getveickm() {
		return veickm;
	}
	public void setveickm(Integer veickm) {
		this.veickm = veickm;
	}
	public Integer getcodmanutencao() {
		return codmanutencao;
	}
	public void setcodmanutencao(Integer codmanutencao) {
		this.codmanutencao = codmanutencao;
	}
	public Double getquantidade() {
		return quantidade;
	}
	public void setquantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public String getvalor() {
		return valor;
	}
	public void setvalor(String valor) {
		this.valor = valor;
	}
	public String getobservacao() {
		return observacao;
	}
	public void setobservacao(String observacao) {
		this.observacao = observacao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -262038540164446134L;
	private Integer codigo;
	private Integer numeronota;
	private LocalDate    dataemissnota;
    private LocalDate    datamvto;
	private Integer veic_codigo;
	private Integer veickm;
	private Integer codmanutencao;
	private Double  quantidade;
	private String  valor;
	private String  observacao;

}
