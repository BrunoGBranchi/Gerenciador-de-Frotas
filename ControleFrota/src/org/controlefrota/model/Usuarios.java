package org.controlefrota.model;


import java.io.Serializable;
import java.time.LocalDate;


public class Usuarios  implements Serializable{

	private static final long serialVersionUID = -5685505098542059847L;
	
	private static Integer nextUsua_codigo = 0;
	private Integer   usua_codigo;
	private String    usua_nome;
	private String    usua_usuario;
	private String    usua_senha;
	private LocalDate usua_datacad;
	
	public static Integer getNextUsua_codigo(){
		nextUsua_codigo += 1;
		return nextUsua_codigo;
		}
	public Integer getUsua_codigo() {
		return usua_codigo;
	}
	public void setUsua_codigo(Integer usua_codigo) {
		this.usua_codigo = usua_codigo;
	}
	public String getUsua_nome() {
		return usua_nome;
	}
	public void setUsua_nome(String usua_nome) {
		this.usua_nome = usua_nome;
	}
	public String getUsua_usuario() {
		return usua_usuario;
	}
	public void setUsua_usuario(String usua_usuario) {
		this.usua_usuario = usua_usuario;
	}
	public String getUsua_senha() {
		return usua_senha;
	}
	public void setUsua_senha(String usua_senha) {
		this.usua_senha = usua_senha;
	}
	public LocalDate getUsua_datacad() {
		return usua_datacad;
	}
	public void setUsua_datacad(LocalDate usua_datacad) {
		this.usua_datacad = usua_datacad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		if (usua_codigo == null) {
			if (other.usua_codigo != null)
				return false;
		} else if (!usua_codigo.equals(other.usua_codigo))
			return false;
		if (usua_datacad == null) {
			if (other.usua_datacad != null)
				return false;
		} else if (!usua_datacad.equals(other.usua_datacad))
			return false;
		if (usua_nome == null) {
			if (other.usua_nome != null)
				return false;
		} else if (!usua_nome.equals(other.usua_nome))
			return false;
		if (usua_senha == null) {
			if (other.usua_senha != null)
				return false;
		} else if (!usua_senha.equals(other.usua_senha))
			return false;
		if (usua_usuario == null) {
			if (other.usua_usuario != null)
				return false;
		} else if (!usua_usuario.equals(other.usua_usuario))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usua_codigo == null) ? 0 : usua_codigo.hashCode());
		result = prime * result + ((usua_datacad == null) ? 0 : usua_datacad.hashCode());
		result = prime * result + ((usua_nome == null) ? 0 : usua_nome.hashCode());
		result = prime * result + ((usua_senha == null) ? 0 : usua_senha.hashCode());
		result = prime * result + ((usua_usuario == null) ? 0 : usua_usuario.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return usua_usuario.toString()+";"+usua_senha.toString();
//		return "Usuarios [usua_codigo=" + usua_codigo + ", usua_nome=" + usua_nome + ", usua_usuario=" + usua_usuario
//				+ ", usua_senha=" + usua_senha + ", usua_datacad=" + usua_datacad + "]";
	}
	public Usuarios(Integer usua_codigo, String usua_nome, String usua_usuario, String usua_senha,
			LocalDate usua_datacad) {
		super();
		this.usua_codigo = usua_codigo;
		this.usua_nome = usua_nome;
		this.usua_usuario = usua_usuario;
		this.usua_senha = usua_senha;
		this.usua_datacad = usua_datacad;
	}
	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	}  

