package com.gestion.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.model.Cliente;
import com.gestion.model.Producto;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

	List<Cliente> findByNombre(String nombre) throws DataAccessException;

	Cliente findByRut(String rut) throws DataAccessException;

	Cliente merge(Cliente cliente);

}

