package com.gestion.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	public List<Producto> findAll();
	
	public Producto findByNombre(String nombre) throws DataAccessException;

	public Producto findById(int id) throws DataAccessException; 
	
	public void delete(int id);
	                   
}         
