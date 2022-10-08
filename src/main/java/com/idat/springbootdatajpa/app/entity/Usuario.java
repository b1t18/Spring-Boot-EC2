package com.idat.springbootdatajpa.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	private String nom_user;
	private String ape_user;
	private String email_user;
	private String tel_user;
	private String dir_user;
	private String codpos_user;
	private String contrasena;
	
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNom_user() {
		return nom_user;
	}
	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}
	public String getApe_user() {
		return ape_user;
	}
	public void setApe_user(String ape_user) {
		this.ape_user = ape_user;
	}
	public String getEmail_user() {
		return email_user;
	}
	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}
	public String getTel_user() {
		return tel_user;
	}
	public void setTel_user(String tel_user) {
		this.tel_user = tel_user;
	}
	public String getDir_user() {
		return dir_user;
	}
	public void setDir_user(String dir_user) {
		this.dir_user = dir_user;
	}
	public String getCodpos_user() {
		return codpos_user;
	}
	public void setCodpos_user(String codpos_user) {
		this.codpos_user = codpos_user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
