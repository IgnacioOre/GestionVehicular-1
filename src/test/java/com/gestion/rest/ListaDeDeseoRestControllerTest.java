package com.gestion.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import com.gestion.model.Cliente;
import com.gestion.model.ListaDeDeseo;
import com.gestion.model.Producto;
import com.gestion.service.ListaDeDeseoServiceImpl;

@ExtendWith(MockitoExtension.class)
class ListaDeDeseoRestControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private ListaDeDeseoServiceImpl listaDeDeseoService;
	
	@InjectMocks
	private ListaDeDeseoRestController listaDeDeseoRestController;
	
	private JacksonTester<List<ListaDeDeseo>> jsonListaDeDeseo;
	
	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(listaDeDeseoRestController).build();
	}
	
	@Test
	void siSeInvocaGetAllProductosYExistenListasDeDeseoRetornaListaDeDeseosYOk() throws Exception {
		//given
		ArrayList<ListaDeDeseo> listasDeDeseo=new ArrayList<ListaDeDeseo>();		
		
		Cliente cliente1=new Cliente("11111111-1","cliente1","apellido1","apellido1","calle123","cliente1@gmail.com");
		Cliente cliente2=new Cliente("22222222-2","cliente2","apellido2","apellido2","calle456","cliente2@gmail.com");
		
		
		ListaDeDeseo listaDeDeseo1=new ListaDeDeseo (12,"Lista1",cliente1);
		ListaDeDeseo listaDeDeseo2=new ListaDeDeseo (12,"Lista1",cliente2);
		
		listasDeDeseo.add(listaDeDeseo1);
		listasDeDeseo.add(listaDeDeseo2);
		
		
		given(listaDeDeseoService.getAllList()).willReturn(listasDeDeseo);
		
		// When	
		MockHttpServletResponse response = mockMvc.perform(get("/lista_de_deseos")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();  
		
		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(
				jsonListaDeDeseo.write(listasDeDeseo).getJson());
		
	}
	
	@Test
	void siSeInvocaGetAllProductosYNoExistenListasDeDeseoRetornaNotFound() throws Exception {
		
		//given
		ArrayList<ListaDeDeseo> listasDeDeseo=new ArrayList<ListaDeDeseo>();
		given(listaDeDeseoService.getAllList()).willReturn(listasDeDeseo);
		
		// When	
		MockHttpServletResponse response = mockMvc.perform(get("/lista_de_deseos")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();  
		
		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());		
		
	}
}
