package com.gestion.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	Producto findByNombre(String nombre) throws DataAccessException;

	Producto findById(int id) throws DataAccessException;

	void delete(int id);
	                   
}         
