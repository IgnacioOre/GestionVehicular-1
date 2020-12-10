package com.gestion.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestion.model.Categoria;
import com.gestion.service.CategoriaServiceImpl;

@ExtendWith(MockitoExtension.class)
class CategoriaRestControllerTest {

	private MockMvc mockMvc;

	@Mock
	private CategoriaServiceImpl categoriaServiceImpl;

	@InjectMocks
	private CategoriaRestController categoriaRestController;

	private JacksonTester<List<Categoria>> jsonListCategoria;

	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(categoriaRestController).build();
	}

	// @Test
	void siSeInvocaGetAllCategoriasYExistenDebeRetornarUnaLIstaYOk() throws Exception {
		// Given
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria(1, "Llantas"));
		categorias.add(new Categoria(2, "Bujias"));

		given(categoriaServiceImpl.getAllCategorias()).willReturn(categorias);

		// When

		MockHttpServletResponse response = mockMvc.perform(get("/categorias").accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(jsonListCategoria.write(categorias).getJson());
	}

	// @Test
	void siSeInvocaGetAllCategoriasYNoExistenDebeRetornarNotFound() throws Exception {
		// Give
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		given(categoriaServiceImpl.getAllCategorias()).willReturn(categorias);

		// When
		MockHttpServletResponse response = mockMvc.perform(get("/categorias").accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}

	// @Test
	void siSeInvocaAddCategoriaConUnaCategoriaValidaDebeAlmacenarlaYRetornarCreated() throws Exception {
		// Give

		// When

		// Then
	}

	// @Test
	void siSeInvocaAddCategoriaConParametroInvalidoDebeRetornarBadRequest() throws Exception {
		// Give

		// When

		// Then
	}
}
