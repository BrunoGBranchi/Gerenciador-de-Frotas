package org.controlefrota.model;

import java.io.Serializable;


public class t_Veiculos implements Serializable {

	private static final long serialVersionUID = -2170492535821015905L;
	private Integer renavam;
	private String marca;
	private String modelo;
	private String placa;
	private String motor;
	private String chassi;
	private String categoria;
	public Integer getrenavam() {
		return renavam;
	}
	public void setrenavam(Integer renavam) {
		this.renavam = renavam;
	}
	public String getmarca() {
		return marca;
	}
	public void setmarca(String marca) {
		this.marca = marca;
	}
	public String getmodelo() {
		return modelo;
	}
	public void setmodelo(String modelo) {
		this.modelo = modelo;
	}
	public String getplaca() {
		return placa;
	}
	public void setplaca(String placa) {
		this.placa = placa;
	}
	public String getmotor() {
		return motor;
	}
	public void setmotor(String motor) {
		this.motor = motor;
	}
	public String getchassi() {
		return chassi;
	}
	public void setchassi(String chassi) {
		this.chassi = chassi;
	}
	public String getcategoria() {
		return categoria;
	}
	public void setcategoria(String categoria) {
		this.categoria = categoria;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((renavam == null) ? 0 : renavam.hashCode());
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
		t_Veiculos other = (t_Veiculos) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (motor == null) {
			if (other.motor != null)
				return false;
		} else if (!motor.equals(other.motor))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (renavam == null) {
			if (other.renavam != null)
				return false;
		} else if (!renavam.equals(other.renavam))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
	return renavam.toString(); 
//		return "t_Veiculos [renavam=" + renavam + ", marca=" + marca + ", modelo="
//				+ modelo + ", placa=" + placa + ", motor=" + motor + ", chassi="
//				+ chassi + ", categoria=" + categoria + "]";
	}
	public t_Veiculos(Integer renavam, String marca, String modelo, String placa, String motor,
			String chassi, String categoria) {
		super();
		this.renavam = renavam;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.motor = motor;
		this.chassi = chassi;
		this.categoria = categoria;
	}
	public t_Veiculos() {
		super();
		// TODO Auto-generated constructor stub
	}


}
