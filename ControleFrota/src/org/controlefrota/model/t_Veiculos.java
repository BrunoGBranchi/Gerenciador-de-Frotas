package org.controlefrota.model;

import java.io.Serializable;


public class t_Veiculos implements Serializable {

	private static final long serialVersionUID = -2170492535821015905L;
	private Integer veic_renavam;
	private String veic_marca;
	private String veic_modelo;
	private String veic_placa;
	private String veic_motor;
	private String veic_chassi;
	private String veic_categoria;
	public Integer getVeic_renavam() {
		return veic_renavam;
	}
	public void setVeic_renavam(Integer veic_renavam) {
		this.veic_renavam = veic_renavam;
	}
	public String getVeic_marca() {
		return veic_marca;
	}
	public void setVeic_marca(String veic_marca) {
		this.veic_marca = veic_marca;
	}
	public String getVeic_modelo() {
		return veic_modelo;
	}
	public void setVeic_modelo(String veic_modelo) {
		this.veic_modelo = veic_modelo;
	}
	public String getVeic_placa() {
		return veic_placa;
	}
	public void setVeic_placa(String veic_placa) {
		this.veic_placa = veic_placa;
	}
	public String getVeic_motor() {
		return veic_motor;
	}
	public void setVeic_motor(String veic_motor) {
		this.veic_motor = veic_motor;
	}
	public String getVeic_chassi() {
		return veic_chassi;
	}
	public void setVeic_chassi(String veic_chassi) {
		this.veic_chassi = veic_chassi;
	}
	public String getVeic_categoria() {
		return veic_categoria;
	}
	public void setVeic_categoria(String veic_categoria) {
		this.veic_categoria = veic_categoria;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((veic_categoria == null) ? 0 : veic_categoria.hashCode());
		result = prime * result + ((veic_chassi == null) ? 0 : veic_chassi.hashCode());
		result = prime * result + ((veic_marca == null) ? 0 : veic_marca.hashCode());
		result = prime * result + ((veic_modelo == null) ? 0 : veic_modelo.hashCode());
		result = prime * result + ((veic_motor == null) ? 0 : veic_motor.hashCode());
		result = prime * result + ((veic_placa == null) ? 0 : veic_placa.hashCode());
		result = prime * result + ((veic_renavam == null) ? 0 : veic_renavam.hashCode());
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
		if (veic_categoria == null) {
			if (other.veic_categoria != null)
				return false;
		} else if (!veic_categoria.equals(other.veic_categoria))
			return false;
		if (veic_chassi == null) {
			if (other.veic_chassi != null)
				return false;
		} else if (!veic_chassi.equals(other.veic_chassi))
			return false;
		if (veic_marca == null) {
			if (other.veic_marca != null)
				return false;
		} else if (!veic_marca.equals(other.veic_marca))
			return false;
		if (veic_modelo == null) {
			if (other.veic_modelo != null)
				return false;
		} else if (!veic_modelo.equals(other.veic_modelo))
			return false;
		if (veic_motor == null) {
			if (other.veic_motor != null)
				return false;
		} else if (!veic_motor.equals(other.veic_motor))
			return false;
		if (veic_placa == null) {
			if (other.veic_placa != null)
				return false;
		} else if (!veic_placa.equals(other.veic_placa))
			return false;
		if (veic_renavam == null) {
			if (other.veic_renavam != null)
				return false;
		} else if (!veic_renavam.equals(other.veic_renavam))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
	return veic_renavam.toString(); 
//		return "t_Veiculos [veic_renavam=" + veic_renavam + ", veic_marca=" + veic_marca + ", veic_modelo="
//				+ veic_modelo + ", veic_placa=" + veic_placa + ", veic_motor=" + veic_motor + ", veic_chassi="
//				+ veic_chassi + ", veic_categoria=" + veic_categoria + "]";
	}
	public t_Veiculos(Integer veic_renavam, String veic_marca, String veic_modelo, String veic_placa, String veic_motor,
			String veic_chassi, String veic_categoria) {
		super();
		this.veic_renavam = veic_renavam;
		this.veic_marca = veic_marca;
		this.veic_modelo = veic_modelo;
		this.veic_placa = veic_placa;
		this.veic_motor = veic_motor;
		this.veic_chassi = veic_chassi;
		this.veic_categoria = veic_categoria;
	}
	public t_Veiculos() {
		super();
		// TODO Auto-generated constructor stub
	}


}
