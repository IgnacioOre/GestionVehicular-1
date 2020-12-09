package com.gestion.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.gestion.model.ListaDeDeseo;
import com.gestion.repository.ListaDeDeseoRepositoryImpl;

class ListaDeseoTest {

	@Mock
	private ListaDeDeseoRepositoryImpl listaDeDeseoRepositoryImpl;
	
	@InjectMocks
	private ListaDeDeseoServiceImpl listaDeDeseoServiceImpl;
	
	@Test
	void siSeInvocaListaDeDeseoRetornaLista() {
		List <ListaDeDeseo> listas = new ArrayList<ListaDeDeseo>();	
		ListaDeDeseo lista = new ListaDeDeseo(1,"ListaMain",null,null);
		listas.add(lista);
		
		when(listaDeDeseoRepositoryImpl.getAllList()).thenReturn(listas);
		
		List <ListaDeDeseo> resultado;
		resultado= listaDeDeseoServiceImpl.getAllList();
		
		assertEquals(listas.size(),resultado.size());
		assertThat(listas.get(0).getId()).isEqualTo(1);
		
	}
	
	@Test
	void siSeInvocaListaDeDeseoYDevuelveListaVacia() {
		List <ListaDeDeseo> listas = new ArrayList<ListaDeDeseo>();	
		when(listaDeDeseoRepositoryImpl.getAllList()).thenReturn(listas);
		
		List <ListaDeDeseo> resultado;
		resultado= listaDeDeseoServiceImpl.getAllList();
		assertEquals(0,resultado.size());
	}

}
