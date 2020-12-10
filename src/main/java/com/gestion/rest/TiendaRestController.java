package com.gestion.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.model.Producto;
import com.gestion.model.Tienda;
import com.gestion.service.TiendaServiceImpl;

@RestController
@RequestMapping("tiendas")
public class TiendaRestController {
	@Autowired
	private TiendaServiceImpl tiendaService;
	
	@PostMapping(value = "/agregar", produces = "application/json")
	public ResponseEntity<Tienda> addTienda(@RequestBody Tienda tienda){
		try {
			tiendaService.save(tienda);
			return new ResponseEntity<Tienda>(tienda,HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Tienda>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@GetMapping(value= "", produces = "application/json")
	public ResponseEntity<List<Tienda>> getAllTiendas() {
		List<Tienda> tiendas = tiendaService.getAllTiendas();
		if (!tiendas.isEmpty()) {
			return new ResponseEntity<List<Tienda>>(tiendas, HttpStatus.OK);
		}
		return new ResponseEntity<List<Tienda>>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value= "/{id}", produces = "application/json")
	public ResponseEntity<Tienda> getTiendaPorId(@PathVariable int id) {
		Tienda tienda = tiendaService.getTiendaPorId(id);
		if (tienda != null) {
			return new ResponseEntity<Tienda>(tienda, HttpStatus.OK);
		}
		return new ResponseEntity<Tienda>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/{id}/agregarExistente", produces = "application/json")
	public ResponseEntity<Tienda> addProductoExistente(@RequestBody Producto producto, @PathVariable int id){
		try {
			Tienda tienda = tiendaService.getTiendaPorId(id);
			tienda.addProducto(producto);
			tiendaService.merge(tienda);
			return new ResponseEntity<Tienda>(tienda,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exceptio
			System.out.println(e.getMessage());
			return new ResponseEntity<Tienda>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping(value = "/{id}/agregarNuevo", produces = "application/json")
	public ResponseEntity<Tienda> addProductoNuevo(@RequestBody Producto producto, @PathVariable int id){
		try {
			Tienda tienda = tiendaService.getTiendaPorId(id);
			tienda.addProducto(producto);
			tiendaService.save(tienda);
			return new ResponseEntity<Tienda>(tienda,HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Tienda>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value= "/buscar/{nombre}", produces = "application/json")
	public ResponseEntity<List<Tienda>> findTiendasByName(@PathVariable String nombre) {
		List<Tienda> tiendas = tiendaService.findByNombre(nombre);
		if (!tiendas.isEmpty()) {
			return new ResponseEntity<List<Tienda>>(tiendas, HttpStatus.OK);
		}
		return new ResponseEntity<List<Tienda>>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value= "/buscar/ciudad/{ciudad}", produces = "application/json")
	public ResponseEntity<List<Tienda>> findTiendasByCiudad(@PathVariable String ciudad) {
		List<Tienda> tiendas = tiendaService.findByCiudad(ciudad);
		if (!tiendas.isEmpty()) {
			return new ResponseEntity<List<Tienda>>(tiendas, HttpStatus.OK);
		}
		return new ResponseEntity<List<Tienda>>(HttpStatus.NOT_FOUND);
	}
	
	

}
