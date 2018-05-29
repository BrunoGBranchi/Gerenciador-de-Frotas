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
@EqualsAndHashCode(of="mvto_forn_codigo")
@ToString(of={"mvto_forn_codigo"})

public class Movimentos implements Serializable{

	public Integer getMvto_forn_codigo() {
		return mvto_forn_codigo;
	}
	public void setMvto_forn_codigo(Integer mvto_forn_codigo) {
		this.mvto_forn_codigo = mvto_forn_codigo;
	}
	public Integer getMvto_numeronota() {
		return mvto_numeronota;
	}
	public void setMvto_numeronota(Integer mvto_numeronota) {
		this.mvto_numeronota = mvto_numeronota;
	}
	public Date getMvto_dataemissnota() {
		return mvto_dataemissnota;
	}
	public void setMvto_dataemissnota(Date mvto_dataemissnota) {
		this.mvto_dataemissnota = mvto_dataemissnota;
	}
	public Date getMvto_datamvto() {
		return mvto_datamvto;
	}
	public void setMvto_datamvto(Date mvto_datamvto) {
		this.mvto_datamvto = mvto_datamvto;
	}
	public Integer getMvto_veic_codigo() {
		return mvto_veic_codigo;
	}
	public void setMvto_veic_codigo(Integer mvto_veic_codigo) {
		this.mvto_veic_codigo = mvto_veic_codigo;
	}
	public Integer getMvto_veickm() {
		return mvto_veickm;
	}
	public void setMvto_veickm(Integer mvto_veickm) {
		this.mvto_veickm = mvto_veickm;
	}
	public Integer getMvto_manu_codigo() {
		return mvto_manu_codigo;
	}
	public void setMvto_manu_codigo(Integer mvto_manu_codigo) {
		this.mvto_manu_codigo = mvto_manu_codigo;
	}
	public Double getMvto_quantidade() {
		return mvto_quantidade;
	}
	public void setMvto_quantidade(Double mvto_quantidade) {
		this.mvto_quantidade = mvto_quantidade;
	}
	public String getMvto_valor() {
		return mvto_valor;
	}
	public void setMvto_valor(String mvto_valor) {
		this.mvto_valor = mvto_valor;
	}
	public String getMvto_observacao() {
		return mvto_observacao;
	}
	public void setMvto_observacao(String mvto_observacao) {
		this.mvto_observacao = mvto_observacao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -262038540164446134L;
	private Integer mvto_forn_codigo;
	private Integer mvto_numeronota;
	private Date    mvto_dataemissnota;
    private Date    mvto_datamvto;
	private Integer mvto_veic_codigo;
	private Integer mvto_veickm;
	private Integer mvto_manu_codigo;
	private Double  mvto_quantidade;
	private String  mvto_valor;
	private String  mvto_observacao;

}
