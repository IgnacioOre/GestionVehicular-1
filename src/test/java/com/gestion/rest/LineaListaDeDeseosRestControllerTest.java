package com.gestion.rest;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.gestion.model.LineaListaDeDeseos;
import com.gestion.model.ListaDeDeseo;
import com.gestion.model.Producto;
import com.gestion.service.LineaListaDeDeseosServiceImpl;

@ExtendWith(MockitoExtension.class)
class LineaListaDeDeseosRestControllerTest {

	private MockMvc mockMvc; 
	
	@Mock
	private LineaListaDeDeseosServiceImpl lineaListaDeseosService;
	
	@InjectMocks
	private LineaListaDeDeseosRestController lineaListaDeDeseosRestCotroller;
	
	private JacksonTester<List<LineaListaDeDeseos>> jsonLineaListaDeDeseos;
	
	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(lineaListaDeDeseosRestCotroller).build();
	}
	
	@Test
	void siSeInvocaGetAllLineaListaDeDeseosYSeAgregaCorrectamenteRetornaLaListaYOK() throws Exception {
		//given		
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
		
		given(lineaListaDeseosService.getAllList()).willReturn(linea);		
		
		//when
		MockHttpServletResponse response = mockMvc.perform(get("/linea_lista_de_deseos")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();  
		
		//Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(
				jsonLineaListaDeDeseos.write(linea).getJson());
		
	}
	
	@Test
	void siSeInvocaGetAllLineaListaDeDeseosYNoExistenRetornaNotFound() throws Exception {
		// Given
		ArrayList<LineaListaDeDeseos> linea = new ArrayList<LineaListaDeDeseos>();
		given(lineaListaDeseosService.getAllList()).willReturn(linea);
		
		// When
		MockHttpServletResponse response = mockMvc.perform(get("/linea_lista_de_deseos")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();  
		
		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());			
	}
}
