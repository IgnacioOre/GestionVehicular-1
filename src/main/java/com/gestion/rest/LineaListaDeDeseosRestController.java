package com.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.model.LineaListaDeDeseos;
import com.gestion.model.Producto;
import com.gestion.service.LineaListaDeDeseosServiceImpl;

@RestController
@RequestMapping("linea_lista_de_deseos")
public class LineaListaDeDeseosRestController {
	
	@Autowired
	private LineaListaDeDeseosServiceImpl lineaListaDeseosService;
	
	@PostMapping(value = "/agregar", produces ="application/json")
	public ResponseEntity<LineaListaDeDeseos> addLineaListaDeDeseo(@RequestBody LineaListaDeDeseos lineaListaDeDeseos){
		
		try {
			lineaListaDeseosService.merge(lineaListaDeDeseos);
			return new ResponseEntity<LineaListaDeDeseos>(lineaListaDeDeseos, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<LineaListaDeDeseos>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping (value = "", produces = "application/json")
	public ResponseEntity<List<LineaListaDeDeseos>> getAllLineaListaDeDeseos(){
		
		List<LineaListaDeDeseos> listaDeDeseo= lineaListaDeseosService.getAllList();
		
		if(!listaDeDeseo.isEmpty()) {
			return new ResponseEntity<List<LineaListaDeDeseos>>(listaDeDeseo, HttpStatus.OK);
		}
		return new ResponseEntity<List<LineaListaDeDeseos>>(HttpStatus.NOT_FOUND);
	}	
	
	@PostMapping(value = "/{id}/agregarProducto", produces = "application/json") 
	public ResponseEntity<LineaListaDeDeseos> addProducto(@RequestBody Producto producto, @PathVariable int id) {
		LineaListaDeDeseos linea = lineaListaDeseosService.findById(id);
		if (linea != null) {
			linea.addProducto(producto);
			lineaListaDeseosService.merge(linea);
			return new ResponseEntity<LineaListaDeDeseos>(linea, HttpStatus.OK);
		}
		return new ResponseEntity<LineaListaDeDeseos>(HttpStatus.NOT_FOUND);
	}
	
}
