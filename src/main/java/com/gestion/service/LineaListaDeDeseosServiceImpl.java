package com.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.model.LineaListaDeDeseos;
import com.gestion.repository.LineaListaDeDeseosRepository;

@Service
public class LineaListaDeDeseosServiceImpl {
	@Autowired
	private LineaListaDeDeseosRepository repo;
	
	@Transactional
	public void save(LineaListaDeDeseos ldd) throws Exception {
		if(ldd == null) {
			throw new Exception();
		}		
		try {
			repo.save(ldd);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}


	public List<LineaListaDeDeseos> getAllList() {
		return repo.getAllList();
	}
	@Transactional
	public void merge(LineaListaDeDeseos ldd) {
		repo.merge(ldd);
		
	}
}

