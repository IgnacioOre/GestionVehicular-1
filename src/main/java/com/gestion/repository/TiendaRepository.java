package com.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gestion.model.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda,Integer> {

	Tienda findTiendaById(int id);

}
