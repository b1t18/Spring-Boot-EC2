package com.idat.springbootdatajpa.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.idat.springbootdatajpa.app.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> 
{

}
