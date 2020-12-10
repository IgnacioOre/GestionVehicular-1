package com.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.model.ListaDeDeseo;
import com.gestion.repository.ListaDeDeseoRepository;

@Service
public class ListaDeDeseoServiceImpl implements ListaDeDeseoService{

	@Autowired
	private ListaDeDeseoRepository repo;
	
	@Transactional
	@Override
	public void save(ListaDeDeseo ldd) throws Exception {
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

	@Override
	public List<ListaDeDeseo> getAllList() {
		return repo.getAllList();
	}
	
	@Transactional
	public void merge(ListaDeDeseo ldd) {
		repo.merge(ldd);
		
	}
}