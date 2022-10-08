package com.idat.springbootdatajpa.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.idat.springbootdatajpa.app.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {

}
