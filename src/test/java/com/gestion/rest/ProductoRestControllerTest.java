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
import com.gestion.model.Producto;
import com.gestion.service.ProductoService;
import com.gestion.service.ProductoServiceImpl;


@ExtendWith(MockitoExtension.class)
class ProductoRestControllerTest {
	private MockMvc mockMvc; 
	
	@Mock
	private ProductoServiceImpl productoService;
	
	@InjectMocks
	private ProductoRestController productoRestController;
	
	private JacksonTester<List<Producto>> jsonListProducto;
	
	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(productoRestController).build();
	}
	
	@Test
	void siSeInvocaGetAllProductosYExistenProductosDebeRetornarListaDeProductosyOk() throws Exception {
	    //Given
	    ArrayList<Producto> productos= new ArrayList<Producto>();
	    productos.add(new Producto (1,"Neumatico","Hankook","k415",70990,24));
	    productos.add(new Producto (2,"Espejo Derecho","TYC","73Y25",12490,20));
	    productos.add(new Producto (3,"Condensador","NEW ERA","4NC-87",1990,10));        
	    given(productoService.getAllProductos()).willReturn(productos);

	    //When
	    MockHttpServletResponse response = mockMvc.perform(get("/productos")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();        

	    //Then
	    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	    assertThat(response.getContentAsString()).isEqualTo(
	            jsonListProducto.write(productos).getJson()
	    );  
	}
	
	@Test
	void siSeInvocaGetAllProductosYNoExistenProductosDebeRetornarNotFound() throws Exception {
		//Given
	    ArrayList<Producto> productos= new ArrayList<Producto>();
	    given(productoService.getAllProductos()).willReturn(productos);
	    
	  //When
	    MockHttpServletResponse response = mockMvc.perform(get("/productos")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();        

	    //Then
	    assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
		
	}

}
