package com.gestion.service;

import static org.junit.jupiter.api.Assertions.*;
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
import com.gestion.model.ListaDeDeseo;
import com.gestion.repository.ListaDeDeseoRepository;

@ExtendWith(MockitoExtension.class)
class ListaDeDeseoServiceTest {
	
	@Mock
	private ListaDeDeseoRepository listaRepo;
	
	@InjectMocks
	private ListaDeDeseoServiceImpl listaServiceImpl;

	@Test
	void siSeInvocaGetAllListYExistenListasDebeRetornarUnaLista() {
		
		//Arrange
		ArrayList<ListaDeDeseo> listaDeDeseos = new ArrayList<ListaDeDeseo>();
		List<ListaDeDeseo> resultado;
		
		Cliente cliente1 = new Cliente("170556549", "Alma", "Marcela", "Gozo", "mi casa", "micorreo");
		
		ListaDeDeseo lista1 = new ListaDeDeseo(1, "Lista Motor", cliente1);
		ListaDeDeseo lista2 = new ListaDeDeseo(2, "Lista Llantas", cliente1);
		ListaDeDeseo lista3 = new ListaDeDeseo(3, "Lista Bujias", cliente1);
		
		listaDeDeseos.add(lista1);
		listaDeDeseos.add(lista2);
		listaDeDeseos.add(lista3);
		
		when(listaServiceImpl.getAllList()).thenReturn(listaDeDeseos);	
		
		// Act
		resultado = listaServiceImpl.getAllList();
		
		// Assert
		assertNotNull(resultado);
		assertEquals(listaDeDeseos.size(), resultado.size());
		assertEquals(lista1.getName(), resultado.get(0).getName());
		assertEquals(cliente1.getNombre(), resultado.get(0).getCliente().getNombre());
	}
	
	@Test
	void siSeInvocaGetAllListYNoExistenListaDeDeseoDevuelveUnaListaVacia() {
		// Arrange
		when(listaServiceImpl.getAllList()).thenReturn(new ArrayList<ListaDeDeseo>());
		List<ListaDeDeseo> resultado;
		
		// Act
		resultado = listaServiceImpl.getAllList();		
		
		// Assert
		assertNotNull(resultado);
		assertEquals(0, resultado.size());
	}
	
	@Test
	void siSeInvocaSaveConUnaListaValidaYNoSeAlmacenaLanzaException() throws Exception {
		// Arrange
		Cliente pedro = new Cliente();
		ListaDeDeseo lista = new ListaDeDeseo(4, "Cosas de interes", pedro);
		
		doThrow(DataRetrievalFailureException.class).when(listaRepo).save(lista);		
		
		// Act + Assert
		assertThrows(Exception.class, ()->listaServiceImpl.save(lista));
	}
}