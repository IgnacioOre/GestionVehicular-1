package com.gestion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.gestion.model.LineaListaDeDeseos;
import com.gestion.model.ListaDeDeseo;
import com.gestion.repository.LineaListaDeDeseosRepositoryImpl;

class LineaListaDeDeseosTest {

	@Mock
	private LineaListaDeDeseosRepositoryImpl lineaListaDeDeseosRepositoryImpl;
	
	@InjectMocks
	private LineaListaDeDeseosServiceImpl lineaListaDeDeseosServiceImpl;
	
	@Test
	void siSeInvocaLineaListaDeDeseosYRetornaLista() {
		List<LineaListaDeDeseos> listas = new ArrayList<LineaListaDeDeseos>();
		List <ListaDeDeseo> listasDeseo = new ArrayList<ListaDeDeseo>();	
		
		ListaDeDeseo listaDeseo = new ListaDeDeseo(1,"ListaMain",null,null);
		ListaDeDeseo deseoList = new ListaDeDeseo();
		
		LineaListaDeDeseos lista = new LineaListaDeDeseos(1,listasDeseo,deseoList,"NomLista");
		listas.add(lista);
		when(lineaListaDeDeseosRepositoryImpl.getAllList()).thenReturn(listas);
		
		List<LineaListaDeDeseos> resultado;
		resultado= lineaListaDeDeseosServiceImpl.getAllList();
		
		assertEquals(listas.size(),resultado.size());
	}
}
