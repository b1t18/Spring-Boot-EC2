package com.idat.springbootdatajpa.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.idat.springbootdatajpa.app.entity.Producto;
import com.idat.springbootdatajpa.app.entity.Usuario;
import com.idat.springbootdatajpa.app.service.IProductoService;

@Controller
public class ProductoController 
{
	@Autowired
	private IProductoService productoService;
	
	@GetMapping(value="/listar_producto")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de Clientes");
		model.addAttribute("clientes",productoService.listarProductos());
		model.addAttribute("aea", 0);
		return "listar_producto";
	}
	
	@GetMapping(value="/ver_producto/{id}")
	public String ver(@PathVariable(value="id") Long id, Map<String,Object> model)
	{
		Producto producto = productoService.editarProducto(id);
		if (producto==null) return "redirect:/listar";
		model.put("cliente", producto);
		model.put("titulo", "Detalle cliente"+producto.getNom_prod());
		return "ver_producto";
	}
	
	@GetMapping(value="/perfil_producto/{id}")
	public String perfil(@PathVariable(value="id") Long id, Model model)
	{
		Producto producto = productoService.editarProducto(id);
		if (producto==null) return "redirect:/";
		model.addAttribute("usuario", producto);
		model.addAttribute("iduser", id);
		return "perfil_producto";
	}
	
	@GetMapping(value="/eliminar_producto/{id}")
	public String eliminar (@PathVariable(value="id") Long id)
	{
		if (id>0)
		{
			productoService.eliminarProducto(id);
		}
		return "redirect:/listar_producto";
	}
	
}
