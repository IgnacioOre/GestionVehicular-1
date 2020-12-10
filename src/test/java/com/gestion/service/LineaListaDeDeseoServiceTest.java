package com.gestion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataRetrievalFailureException;

import com.gestion.model.Cliente;
import com.gestion.model.LineaListaDeDeseos;
import com.gestion.model.ListaDeDeseo;
import com.gestion.model.Producto;
import com.gestion.repository.LineaListaDeDeseosRepository;

@ExtendWith(MockitoExtension.class)
class LineaListaDeDeseoServiceTest {

	@Mock
	private LineaListaDeDeseosRepository lineaRepo;
	
	@InjectMocks
	private LineaListaDeDeseosServiceImpl lineaServiceImpl;
	
	@Test
	void siSeInvocaGetAllListYExistenListasRetoranUnaLista() {
		// Arrange		
		Cliente cliente = new Cliente("123456789", "Alejandra", "Ortiz", "Cea", "suCasa", "suCorreo@gmail.com");
		
		ListaDeDeseo listaDeseo = new ListaDeDeseo(1, "cosas cliente", cliente);		
		
		ArrayList<LineaListaDeDeseos> linea = new ArrayList<LineaListaDeDeseos>();
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Producto a = new Producto(1, "nombreA", "marcaA", "modeloA", 12000, 12);
		Producto b = new Producto(2, "nombreB", "marcaB", "modeloB", 22000, 13);
		
		productos.add(a);
		productos.add(b);
		
		LineaListaDeDeseos linea1 = new LineaListaDeDeseos(1, productos, listaDeseo, "cosas varias");
		
		linea.add(linea1);
		
		when(lineaRepo.getAllList()).thenReturn(linea);
		List<LineaListaDeDeseos> resultado;
		
		// Act
		
		resultado = lineaServiceImpl.getAllList();
			
		// Assert
		
		assertNotNull(resultado);
		assertEquals(linea.size(), resultado.size());
		assertEquals(linea.get(0).getId_linea(), resultado.get(0).getId_linea());
		
	}
	
	@Test
	void siSeInvocaGetAllListYNoExistenListasRetornarListaVacia() {
		// Arrange
		when(lineaServiceImpl.getAllList()).thenReturn(new ArrayList<LineaListaDeDeseos>());
		List<LineaListaDeDeseos> resultado;
		
		// Act
		resultado = lineaServiceImpl.getAllList();		
		
		// Assert
		assertNotNull(resultado);
		assertEquals(0, resultado.size());		
	}
	
	@Test
	void siSeInvocaSaveConUnaListaValidaYNoSePuedeGuardarLanzaException() {
		
		// Arrange
		Cliente cliente = new Cliente("123456789", "Alejandra", "Ortiz", "Cea", "suCasa", "suCorreo@gmail.com");
		
		ListaDeDeseo listaDeseo = new ListaDeDeseo(1, "cosas cliente", cliente);		
		
		ArrayList<LineaListaDeDeseos> linea = new ArrayList<LineaListaDeDeseos>();
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Producto a = new Producto(1, "nombreA", "marcaA", "modeloA", 12000, 12);
		Producto b = new Producto(2, "nombreB", "marcaB", "modeloB", 22000, 13);
		
		productos.add(a);
		productos.add(b);
		
		LineaListaDeDeseos linea1 = new LineaListaDeDeseos(1, productos, listaDeseo, "cosas varias");
		
		linea.add(linea1);
		doThrow(DataRetrievalFailureException.class).when(lineaRepo).save(linea1);
		
		// Act + Assert
		assertThrows(Exception.class,()->lineaServiceImpl.save(linea1));
	}
}