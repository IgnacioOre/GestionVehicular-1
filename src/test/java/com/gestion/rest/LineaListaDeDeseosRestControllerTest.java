package com.gestion.rest;

import static org.junit.jupiter.api.Assertions.*;

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
import com.gestion.model.LineaListaDeDeseos;
import com.gestion.model.Producto;
import com.gestion.service.LineaListaDeDeseosServiceImpl;
import com.gestion.service.ProductoServiceImpl;

@ExtendWith(MockitoExtension.class)
class LineaListaDeDeseosRestControllerTest {

	private MockMvc mockMvc; 
	
	@Mock
	private LineaListaDeDeseosServiceImpl lineaListaDeseosService;
	
	@InjectMocks
	private LineaListaDeDeseosRestController lineaListaDeDeseosRestCotroller;
	
	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(lineaListaDeDeseosRestCotroller).build();
	}
	
	@Test
	void siSeInvocaGetAllLineaListaDeDeseosYSeAgregaCorrectamenteRetornaLaListaYOK() {
		//given
		ArrayList <LineaListaDeDeseos> listaDeDeseo= new ArrayList<LineaListaDeDeseos>();
		
		
		
		
		//when
		
		//Then
		
	}
}
