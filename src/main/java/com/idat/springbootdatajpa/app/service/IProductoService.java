package com.idat.springbootdatajpa.app.service;

import java.util.List;

import com.idat.springbootdatajpa.app.entity.Producto;

public interface IProductoService 
{
	//Crearemos los métodos:
	
		//Método 1: Listar los clientes:
		public List<Producto> listarProductos();
		
		//Método 2: Crear un cliente:
		public void crearProducto(Producto producto);
		
		//Método 3: Editar un cliente:
		public Producto editarProducto(Long id);
		
		//Método 4: Eliminar un cliente:
		public void eliminarProducto(Long id);
}
