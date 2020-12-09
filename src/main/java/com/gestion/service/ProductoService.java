package com.gestion.service;

import java.util.List;

import com.gestion.model.Producto;

public interface ProductoService {
	public List<Producto> getAllProductos();
	
	void save(Producto producto) throws Exception;
	
	public Producto findByNombre(String nombre);
	
}
