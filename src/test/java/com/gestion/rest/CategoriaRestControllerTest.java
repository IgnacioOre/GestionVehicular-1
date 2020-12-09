package com.gestion.rest;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestion.model.Categoria;
import com.gestion.service.CategoriaServiceImpl;

@ExtendWith(MockitoExtension.class)
class CategoriaRestControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private CategoriaServiceImpl categoriServiceImpl;
	
	@InjectMocks
	private CategoriaRestController categoriaRestController;
	
	private JacksonTester<List<Categoria>> jsonListCategoria;
	
	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(categoriaRestController).build();
	}

	@Test
	void siSeInvocaGetAllCategoriasYExistenDebeRetornarUnaLIstaYOk() {
		// Given
		ArrayList<Categoria> categoria = new ArrayList<Categoria>();
		
		// When
		
		// Then
	}
	
	//@Test
	void siSeInvocaGetAllCategoriasYNoExistenDebeRetornarUnaListaVaciaYNoContent() {
		fail("Not yet implemented");
	}
	
	//@Test
	void siSeInvocaAddCategoriaConUnaCategoriaValidaDebeAlmacenarlaYOk() {
		fail("Not yet implemented");
	}
	
	//@Test
	void siSeInvocaAddCategoriaConParametroInvalidoDebeRetornarBadRequest() {
		fail("Not yet implemented");
	}
}
