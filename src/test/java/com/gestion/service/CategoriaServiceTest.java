package com.gestion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gestion.model.Categoria;
import com.gestion.repository.CategoriaRepositoryImpl;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {
	
	@Mock
	private CategoriaRepositoryImpl categoriaRepo;
	
	@InjectMocks
	private CategoriaServiceImpl categoriaServiceImpl;

	@Test
	void siSeInvocaGetAllCategoriasYExistenCategoriasDebeRetornarListaDeProducto() {
		
		// Arrange			
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria(2, "Bujias"));
		categorias.add(new Categoria(3, "Luces"));
		categorias.add(new Categoria(4, "Neumaticos"));
		when(categoriaRepo.findAll()).thenReturn(categorias);
		List<Categoria> resultado;		
		
		// Act
		resultado = categoriaServiceImpl.getAllCategorias();
		
		// Assert
		assertNotNull(resultado);
		assertEquals(categorias.size(), resultado.size());
		assertEquals("Luces", resultado.get(1).getNombre_cat());
	}
	
	@Test
	void siSeInvocaGetAllCategoriasYNoExistenCategoriasDevuelveUnaListaVacia() {
		
		// Arrange
			ArrayList<Categoria> categorias = new ArrayList<Categoria>();
			when(categoriaRepo.findAll()).thenReturn(categorias);
			List<Categoria> resultado;
		
		// Act
			resultado = categoriaServiceImpl.getAllCategorias();
	
		// Assert
			assertEquals(0, resultado.size());
	}
}