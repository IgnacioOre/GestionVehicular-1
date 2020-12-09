package com.gestion.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

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
import com.gestion.model.Producto;
import com.gestion.service.ClienteServiceImpl;

@ExtendWith(MockitoExtension.class)
class ClienteRestControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private ClienteServiceImpl clienteService;
	
	@InjectMocks
	private ClienteRestController clienteRestController;
	
	private JacksonTester<Cliente> jsonCliente;
	
	private JacksonTester<List<Cliente>> jsonListCliente;
	
	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(clienteRestController).build();
	}
	/*@Test
	void siSeInvocaAddClienteYSeAgregaClienteExitosamenteDebeRetornarClienteYCreated() {
		//given
		 * Cliente cliente=new Cliente("11111111-1","Danidec","Cea","Gajardo","Roble123","Danidec@gmail.com");
		
		given(clienteService.save(cliente)).willReturn(cliente);

	    //When
	    MockHttpServletResponse response = mockMvc.perform(get("/clientes/agregar")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();        

	    //Then
	    assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	    assertThat(response.getContentAsString()).isEqualTo(
	            jsonCliente.write(cliente).getJson()
	    ); 
	}*/
	/*
	@Test
	void SiSeInvocaGetAllClientesYExistenClientesRetornaUnaListaDeClientesYOk() throws Exception{
		//given
		ArrayList <Cliente> clientes=new ArrayList<Cliente>();
		Cliente cliente1= new Cliente("11111111-1","Danidec","Cea","Gajardo","Roble123","Danidec@gmail.com");
		Cliente cliente2= new Cliente("22222222-2","Jose","Aedo","Cea","Maipu345","jose@gmail.com");
		Cliente cliente3=new Cliente("33333333-3","Edith","Ponce","Carez","Collin56","Edith@gmail.com");
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		given(clienteService.getAllClientes()).willReturn(clientes);
		
		//When
		MockHttpServletResponse response = mockMvc.perform(get("/clientes")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();        

	    //Then
	    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	    assertThat(response.getContentAsString()).isEqualTo(
	            jsonListCliente.write(clientes).getJson()
	    );	
	}
	
	@Test
	void SiSeInvocaGetAllClientesYNoExistenClientesRetornaNotFound() throws Exception{
		
		//given
		given(clienteService.getAllClientes()).willReturn(new ArrayList <Cliente>());
		
		//When
		MockHttpServletResponse response = mockMvc.perform(get("/clientes")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();        

	    //Then
	    assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());	
	}*/
	
	@Test
	void siSeInvocaUpdateClienteYElClienteEsValidoRetornaElClienteYOk() throws Exception {
		//given
		Cliente cliente= new Cliente("22222222-2","Jose","Aedo","Cea","Maipu345","jose@gmail.com");	
		Cliente clienteNuevo= new Cliente("22222222-2","Jose","Aedo","Ortiz","Maipu345","jose@gmail.com");	
		
		given(clienteService.getClientePorRut("22222222-2")).willReturn(cliente);

		given(clienteService.merge(clienteNuevo));
		
		//When
		MockHttpServletResponse response = mockMvc.perform(put("/clientes/22222222-2")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();        

	    //Then
	    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	    //assertThat(response.getContentAsString()).isEqualTo(
	      //      jsonCliente.write(cliente).getJson()
	    //);	
		
	}
	
	/*@Test
	void siSeInvocaUpdateClienteYElClienteNoEsValidoLanzaUnaExceptionYBadRequest() throws Exception {
		//given
		doThrow(Exception.class).when(clienteService).getClientePorRut("22222222-2");

		
		//When
		MockHttpServletResponse response = mockMvc.perform(get("/clientes/22222222-2")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();        

	    //Then
	    assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());	
	}*/
	/*
	@Test
	void siSeInvocaUpdateClienteYElClienteEsNullRetornaNotFound() throws Exception {
		//given
		given(clienteService.getClientePorRut("22222222-2")).willReturn(null);
		
		//When
		MockHttpServletResponse response = mockMvc.perform(put("/clientes/22222222-2")
	            .accept(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse();        

	    //Then
	    assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	
	}*/

}
