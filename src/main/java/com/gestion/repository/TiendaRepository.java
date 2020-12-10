package com.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.model.Producto;
import com.gestion.model.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda,Integer> {

	Tienda findTiendaById(int id);

	List<Tienda> findByNombre(String nombre);

	List<Tienda> findByCiudad(String ciudad);

	void merge(Tienda tienda);

}
