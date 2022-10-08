package com.idat.springbootdatajpa.app.service;

import java.util.List;

import com.idat.springbootdatajpa.app.entity.Usuario;

public interface IUsuarioService 
{
	//Crearemos los métodos:
	
	//Método 1: Listar los clientes:
	public List<Usuario> listarUsuarios();
	
	//Método 2: Crear un cliente:
	public void crearCliente(Usuario usuario);
	
	//Método 3: Editar un cliente:
	public Usuario editarUsuario(Long id);
	
	//Método 4: Eliminar un cliente:
	public void eliminarUsuario(Long id);
}
