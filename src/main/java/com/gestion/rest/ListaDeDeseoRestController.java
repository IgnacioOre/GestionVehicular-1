package com.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.model.ListaDeDeseo;
import com.gestion.service.ListaDeDeseoServiceImpl;

@RestController
public class ListaDeDeseoRestController {

	@Autowired
	private ListaDeDeseoServiceImpl listaDeseoService;
	
	@PostMapping(value = "/lista_de_deseos/agregar", produces ="application/json")
	public ResponseEntity<ListaDeDeseo> addNewList(@RequestBody ListaDeDeseo ldd){
		try {
			listaDeseoService.save(ldd);
			return new ResponseEntity<ListaDeDeseo>(ldd, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<ListaDeDeseo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping (value = "/lista_de_deseos", produces = "application/json")
	public ResponseEntity<List<ListaDeDeseo>> getAllProductos(){
		
		List <ListaDeDeseo> ldd = listaDeseoService.getAllList();
		
		if(!ldd.isEmpty()) {
			return new ResponseEntity<List<ListaDeDeseo>>(ldd, HttpStatus.OK);
		}
		return new ResponseEntity<List<ListaDeDeseo>>(HttpStatus.NOT_FOUND);

	}
	
}
