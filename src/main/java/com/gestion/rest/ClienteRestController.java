package com.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.exceptions.GestionVehicularException;
import com.gestion.model.Cliente;
import com.gestion.model.Producto;
import com.gestion.service.ClienteServiceImpl;


@RestController
@RequestMapping("clientes")
public class ClienteRestController {
	
	@Autowired
	private ClienteServiceImpl clienteService;
	
	@PostMapping(value = "/agregar", produces ="application/json")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		
		try {
			clienteService.save(cliente);
			return new ResponseEntity<Cliente> (cliente, HttpStatus.CREATED);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PutMapping("/{rut}")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, @PathVariable String rut) {
		Cliente clienteAux;
		try {
			clienteAux = clienteService.getClientePorRut(rut);
		} catch (GestionVehicularException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
		try {
			clienteService.merge(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Cliente> (cliente, HttpStatus.OK);

	}
	
	@GetMapping (value= "", produces = "application/json")
	public ResponseEntity<List<Cliente>> gettAllClientes(){
		
		List <Cliente> clientes = clienteService.getAllClientes();
		
		if(!clientes.isEmpty()) {
			return new ResponseEntity<List <Cliente>>(clientes,HttpStatus.OK);
		}
		return new ResponseEntity<List<Cliente>>(HttpStatus.NOT_FOUND);
			
	}
	
	@DeleteMapping(value = "/eliminar")
	public ResponseEntity<Cliente> deleteCliente (@RequestParam String rut) {	
		try {
			Cliente cliente = clienteService.getClientePorRut(rut);	
			clienteService.delete(cliente);
			return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}

	}

}
