package com.gestion.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.gestion.model.Tienda;
import com.gestion.repository.TiendaRepository;

@Service
public class TiendaServiceImpl implements TiendaService {
	@Autowired
	private TiendaRepository repo;

	@Override
	public List<Tienda> getAllTiendas() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Transactional
	@Override
	public void save(Tienda tienda) throws Exception {
		// TODO Auto-generated method stub
		if (tienda == null) {
			throw new Exception();
		}
		try {
			repo.save(tienda);
		} catch (DataAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}

	}

}
