package com.gestion.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
	
	public List<Cliente> findAll();
	
	public List<Cliente> findByNombre(String nombre) throws DataAccessException;
	
	public void delete(Cliente entity);
	
	public Cliente findByRut(String rut) throws DataAccessException;

	public Cliente merge(Cliente cliente);

}

