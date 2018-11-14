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
@EqualsAndHashCode(of="codigo")
@ToString(of={"codigo"})


/*LOMBOK QUE TAVA FAZENDO A BOSTA DE NÃO RENDERIZAR A TABELA, CRIA GET E SET MANUALMENTE (PELO ALT+SHIFT+S) BJS*/


public class Usuarios  implements Serializable{

	private static final long serialVersionUID = -5685505098542059847L;
	
	private Integer codigo;
	private String nome;
	private String usuario;
	private String senha;
	private Date datacad;
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
}  

