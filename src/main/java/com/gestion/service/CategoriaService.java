package com.gestion.service;

import java.util.List;

import com.gestion.model.Categoria;

public interface CategoriaService {
	void save(Categoria categoria) throws Exception;

	public List<Categoria> getAllCategorias();	
}