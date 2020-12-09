package com.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.model.Categoria;
import com.gestion.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository repo;
	

	@Override
	public List<Categoria> getAllCategorias() {
		return repo.findAll();
	}
	
	@Transactional
	@Override
	public void save(Categoria categoria) throws Exception {
		if (categoria == null) {
			throw new Exception();
		}
		try {
			repo.save(categoria);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}
}