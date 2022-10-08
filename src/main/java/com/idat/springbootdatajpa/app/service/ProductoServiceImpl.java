package com.idat.springbootdatajpa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.springbootdatajpa.app.dao.IProductoDao;
import com.idat.springbootdatajpa.app.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDao productoDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Producto> listarProductos() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional
	public void crearProducto(Producto producto) {
		productoDao.save(producto);
		
	}

	@Override
	@Transactional
	public Producto editarProducto(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminarProducto(Long id) {
		productoDao.deleteById(id);
	}





}
