package com.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}
