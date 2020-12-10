package com.gestion.service;

import java.util.List;

import com.gestion.model.Producto;

public interface ProductoService {
	
	public List<Producto> getAllProductos();
	
	public Producto findByNombre(String nombre);
	
	public Producto findByInt(int id);
	
	void save(Producto producto) throws Exception;
	
	public void delete(int id) throws Exception;
	
	
}
