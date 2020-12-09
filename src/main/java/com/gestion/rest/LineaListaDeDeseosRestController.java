package com.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.model.LineaListaDeDeseos;
import com.gestion.model.ListaDeDeseo;
import com.gestion.service.LineaListaDeDeseosServiceImpl;
import com.gestion.service.ListaDeDeseoServiceImpl;

@RestController
@RequestMapping("linea_lista_de_deseos")
public class LineaListaDeDeseosRestController {
	
	@Autowired
	private LineaListaDeDeseosServiceImpl lineaListaDeseosService;
	
	@PostMapping(value = "/agregar", produces ="application/json")
	public ResponseEntity<LineaListaDeDeseos> addLineaListaDeDeseo(@RequestBody LineaListaDeDeseos lineaListaDeDeseos){
		
		try {
			lineaListaDeseosService.save(lineaListaDeDeseos);
			return new ResponseEntity<LineaListaDeDeseos>(lineaListaDeDeseos, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<LineaListaDeDeseos>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping (value = "", produces = "application/json")
	public ResponseEntity<List<LineaListaDeDeseos>> getAllLineaListaDeDeseos(){
		
		List <LineaListaDeDeseos> listaDeDeseo= lineaListaDeseosService.getAllList();
		
		if(!listaDeDeseo.isEmpty()) {
			return new ResponseEntity<List<LineaListaDeDeseos>>(listaDeDeseo, HttpStatus.OK);
		}
		return new ResponseEntity<List<LineaListaDeDeseos>>(HttpStatus.NOT_FOUND);

	}	
	
}
