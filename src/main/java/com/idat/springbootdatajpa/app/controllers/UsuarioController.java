package com.idat.springbootdatajpa.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.idat.springbootdatajpa.app.entity.Usuario;
import com.idat.springbootdatajpa.app.service.IUsuarioService;

@Controller
public class UsuarioController 
{
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping(value="/")
	public String index(Model model) 
	{
		model.addAttribute("aea", 0);
		return "index";
	}
	
	@GetMapping(value="/login")
	public String listar() 
	{
		return "login";
	}
	
	@PostMapping(value="/login")
	public String listarpost(Model model, String usuario, String pass)
	{
		List<Usuario> userlista = new ArrayList<>();
		
		userlista = usuarioService.listarUsuarios();
		//System.out.println(usuario); // comprobar si llega el dato usuario xd
		
		for (int i=0; i < userlista.size(); i++)
		{
			if (userlista.get(i).getEmail_user().equals(usuario) && userlista.get(i).getContrasena().equals(pass))
			{
				model.addAttribute("aea", 1);
				model.addAttribute("idnombre", userlista.get(i).getNom_user());
				model.addAttribute("iduser", userlista.get(i).getId_usuario());
				return "index";
			}
		}
		
		model.addAttribute("estado", 0);
		return "login";
	}
	
	@GetMapping(value="/perfil/{id}")
	public String perfil(@PathVariable(value="id") Long id, Model model)
	{
		Usuario usuario = usuarioService.editarUsuario(id);
		if (usuario==null) return "redirect:/";
		model.addAttribute("usuario", usuario);
		model.addAttribute("iduser", id);
		return "perfil";
	}
	
	@GetMapping(value="/Registro")
	public String registropost(Model model)
	{
		model.addAttribute("Nombre", "REGISTRATE AQUI");
		return "Registro";
	}
	
	@PostMapping(value="/Registro")
	public String registro(Model model, String nombre, String apellido, String contra, String correo, String telefono, String direccion, String Cod_Postal)
	{
		
		/*List<Usuario> userlista = new ArrayList<>();
		userlista = usuarioService.listarUsuarios();
		
		boolean existe = false;
		for (int i=0; i<userlista.size(); i++)
		{
			if (userlista.get(i).getEmail_user().equals(correo))
			{
				existe = true;
			}
		}
		
		if (existe) return "Registro";*/
		
		Usuario user = new Usuario();
		user.setNom_user(nombre);
		user.setApe_user(apellido);
		user.setContrasena(contra);
		user.setEmail_user(correo);
		user.setTel_user(telefono);
		user.setDir_user(direccion);
		user.setCodpos_user(Cod_Postal);
		usuarioService.crearCliente(user);
		model.addAttribute("Nombre", "REGISTRATE AQUI");
		return "Registro";
	}
	
	@GetMapping(value="/listar")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de Clientes");
		model.addAttribute("clientes",usuarioService.listarUsuarios());
		model.addAttribute("aea", 0);
		return "listar";
	}
	
	
		@GetMapping(value="/ver/{id}")
		public String ver(@PathVariable(value="id") Long id, Map<String,Object> model)
		{
			Usuario usuario = usuarioService.editarUsuario(id);
			if (usuario==null) return "redirect:/listar";
			model.put("cliente", usuario);
			model.put("titulo", "Detalle cliente"+usuario.getNom_user());
			return "ver";
		}
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar (@PathVariable(value="id") Long id)
	{
		if (id>0)
		{
			usuarioService.eliminarUsuario(id);
		}
		return "redirect:/listar";
	}
}
