package com.gestion.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.model.Tienda;
import com.gestion.service.TiendaServiceImpl;

@RestController
@RequestMapping("tiendas")
public class TiendaRestController {
	@Autowired
	private TiendaServiceImpl tiendaService;
	
	@PostMapping(value = "/agregar", produces = "application/json")
	public ResponseEntity<Tienda> addCategoria(@RequestBody Tienda tienda){
		try {
			tiendaService.save(tienda);
			return new ResponseEntity<Tienda>(tienda,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exceptio
			System.out.println(e.getMessage());
			return new ResponseEntity<Tienda>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
