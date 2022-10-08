package com.idat.springbootdatajpa.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;
	private String nom_prod;
	private double precio;
	private int stock;
	
	
	public Long getId_producto() {
		return id_producto;
	}
	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}
	public String getNom_prod() {
		return nom_prod;
	}
	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
