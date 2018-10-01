package org.controlefrota.model;


import java.io.Serializable;
import java.sql.Date;

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
@EqualsAndHashCode(of="forn_codigo")
@ToString(of={"forn_codigo"})

public class Movimentos implements Serializable{

	public Integer getforn_codigo() {
		return forn_codigo;
	}
	public void setforn_codigo(Integer forn_codigo) {
		this.forn_codigo = forn_codigo;
	}
	public Integer getnumeronota() {
		return numeronota;
	}
	public void setnumeronota(Integer numeronota) {
		this.numeronota = numeronota;
	}
	public Date getdataemissnota() {
		return dataemissnota;
	}
	public void setdataemissnota(Date dataemissnota) {
		this.dataemissnota = dataemissnota;
	}
	public Date getdatamvto() {
		return datamvto;
	}
	public void setdatamvto(Date datamvto) {
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
	public Integer getmanu_codigo() {
		return manu_codigo;
	}
	public void setmanu_codigo(Integer manu_codigo) {
		this.manu_codigo = manu_codigo;
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
	private Integer forn_codigo;
	private Integer numeronota;
	private Date    dataemissnota;
    private Date    datamvto;
	private Integer veic_codigo;
	private Integer veickm;
	private Integer manu_codigo;
	private Double  quantidade;
	private String  valor;
	private String  observacao;

}
