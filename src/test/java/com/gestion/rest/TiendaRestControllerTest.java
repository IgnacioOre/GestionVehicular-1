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
import com.gestion.model.Producto;
import com.gestion.model.Tienda;
import com.gestion.service.ProductoServiceImpl;
import com.gestion.service.TiendaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TiendaRestControllerTest {
	private MockMvc mockMvc; 
	
	@Mock
	private TiendaServiceImpl tiendaService;
	
	@InjectMocks
	private TiendaRestController tiendaRestController;
	
	private JacksonTester<List<Tienda>> jsonListTienda;
	
	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(tiendaRestController).build();
	}
	
	@Test
	void siSeInvocaGetAllTiendasYExistenTiendasDebeRetornarListaDeTiendasyOk() throws Exception {
	    //Given
	    ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
	    tiendas.add(new Tienda(1, "Repuestos Garcia", "Chillan", null));  
	    tiendas.add(new Tienda(2, "Centro Repuestos", "Chillan", null));     
	    tiendas.add(new Tienda(3, "Casa de Repuestos", "Chillan", null));     
	    given(tiendaService.getAllTiendas()).willReturn(tiendas);

	    //When
	    MockHttpServletResponse response = mockMvc.perform(get("/tiendas")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();        

	    //Then
	    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	    assertThat(response.getContentAsString()).isEqualTo(
	            jsonListTienda.write(tiendas).getJson()
	    );  
	}
}
