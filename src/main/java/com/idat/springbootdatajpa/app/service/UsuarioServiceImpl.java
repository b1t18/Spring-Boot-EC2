package com.idat.springbootdatajpa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.springbootdatajpa.app.dao.IUsuarioDao;
import com.idat.springbootdatajpa.app.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService 
{
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Usuario> listarUsuarios() 
	{
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void crearCliente(Usuario usuario) 
	{
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public Usuario editarUsuario(Long id) 
	{
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminarUsuario(Long id) 
	{
		usuarioDao.deleteById(id);
	}

}
