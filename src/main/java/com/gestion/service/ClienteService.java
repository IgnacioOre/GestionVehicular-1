package com.gestion.service;

import java.util.List;

import com.gestion.exceptions.GestionVehicularException;
import com.gestion.model.Cliente;

public interface ClienteService {
	
	public List<Cliente> getAllClientes();
	
	void save(Cliente cliente) throws Exception;
	
	public Cliente getClientePorRut(String rut) throws GestionVehicularException;
	
	public Cliente merge(Cliente cliente);
	
	public void delete(Cliente cliente) throws GestionVehicularException;

}


 