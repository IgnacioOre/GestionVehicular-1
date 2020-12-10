package com.gestion.rest;

import static org.junit.jupiter.api.Assertions.*;

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
import com.gestion.model.Producto;
import com.gestion.service.ProductoServiceImpl;
import com.gestion.service.TiendaServiceImpl;

@ExtendWith(MockitoExtension.class)
class TiendaRestControllerTest {

	private MockMvc mockMvc; 
	
	@Mock
	private TiendaServiceImpl tiendaService;
	
	@InjectMocks
	private TiendaRestController productoRestController;
	
	private JacksonTester<List<Producto>> jsonListProducto;
	
	
	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(productoRestController).build();
	}
}
