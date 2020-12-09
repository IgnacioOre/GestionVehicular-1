package com.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.exceptions.GestionVehicularException;
import com.gestion.model.Cliente;
import com.gestion.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public List<Cliente> getAllClientes() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Transactional
	@Override
	public void save(Cliente cliente) throws Exception {
		
		if(cliente==null) {
			throw new Exception();
		}
		try {
			repo.save(cliente);
			
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new Exception();
		}		
		
	}

	public Cliente getClientePorRut(String rut) throws GestionVehicularException{
		Cliente cliente = repo.findByRut(rut);
		if (cliente == null) {
			throw new GestionVehicularException();
		} else {
			return cliente;
		}
	}

	@Transactional
	public Cliente merge(Cliente cliente) {
		return repo.merge(cliente);
	}
	
	@Transactional
	public void delete(Cliente cliente) throws GestionVehicularException {
		try {
			repo.delete(cliente);
		} catch (DataAccessException e) {
			throw new GestionVehicularException();
		}
		
	}


}
