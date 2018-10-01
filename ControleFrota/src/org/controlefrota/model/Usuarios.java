package org.controlefrota.model;


import java.io.Serializable;
import java.time.LocalDate;


public class Usuarios  implements Serializable{

	private static final long serialVersionUID = -5685505098542059847L;
	
	private static Integer nextcodigo = 0;
	private Integer   codigo;
	private String    nome;
	private String    usuario;
	private String    senha;
	private LocalDate datacad;
	
	public static Integer getNextcodigo(){
		nextcodigo += 1;
		return nextcodigo;
		}
	public Integer getcodigo() {
		return codigo;
	}
	public void setcodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}
	public String getusuario() {
		return usuario;
	}
	public void setusuario(String usuario) {
		this.usuario = usuario;
	}
	public String getsenha() {
		return senha;
	}
	public void setsenha(String senha) {
		this.senha = senha;
	}
	public LocalDate getdatacad() {
		return datacad;
	}
	public void setdatacad(LocalDate datacad) {
		this.datacad = datacad;
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((datacad == null) ? 0 : datacad.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return usuario.toString()+";"+senha.toString();
//		return "Usuarios [codigo=" + codigo + ", nome=" + nome + ", usuario=" + usuario
//				+ ", senha=" + senha + ", datacad=" + datacad + "]";
	}
	public Usuarios(Integer codigo, String nome, String usuario, String senha,
			LocalDate datacad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.datacad = datacad;
	}
	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	}  

