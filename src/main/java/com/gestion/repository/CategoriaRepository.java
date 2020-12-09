package com.gestion.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.model.Categoria;
import com.gestion.model.Producto;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}
