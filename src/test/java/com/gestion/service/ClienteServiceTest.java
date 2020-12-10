package com.gestion.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gestion.model.Cliente;
import com.gestion.repository.ClienteRepositorylmpl;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {	
	
	@Mock
	private ClienteRepositorylmpl clienteRepositoryImpl;
	
	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;
	
	@Test
	void siSeInvocaGetAllClientesDebeRetornarListaCliente() {
		List <Cliente> cliente = new ArrayList<Cliente>();
		Cliente clientes = new Cliente("111-1","Daniel","Lopez","Lopez","San Carlos","emailDan@mail");
		Cliente clientedos = new Cliente("222-2","Patricio","Parra","Soto","Chillan","gmailPato@mail");
		cliente.add(clientes);
		cliente.add(clientedos);
		
		when(clienteRepositoryImpl.findAll()).thenReturn(cliente);
		
		List<Cliente> resultado;
		resultado= clienteServiceImpl.getAllClientes();
		
		assertEquals(cliente.size(),resultado.size());
		assertThat(cliente.get(0).getRut()).isEqualTo("111-1");
	}
	
	@Test
	void siSeInvocaGetAllClientesYNoExistenClientesDevuelveUnaListaVacia() {
		List <Cliente> cliente = new ArrayList<Cliente>();
		when(clienteRepositoryImpl.findAll()).thenReturn(cliente);
		
		List <Cliente> resultado;
		resultado= clienteServiceImpl.getAllClientes();
		
		assertEquals(0,resultado.size());
				
	}
	
	 @Test
	 void siSeInvocaSaveYSeGuardaCliente() throws Exception {
		List <Cliente> cliente = new ArrayList<>();
		Cliente clientes = new Cliente("111-3","Daniel","Lopez","Lopez","San Carlos","emailDan@mail");
		cliente.add(clientes);
		clienteServiceImpl.save(clientes);
		Mockito.verify(clienteRepositoryImpl,times(1)).save(clientes);
		
	 }
	 
	 @Test
	 void siSeInvocaSaveYSeLanzaException() throws Exception{
			assertThrows(Exception.class,()->clienteServiceImpl.save(null));
	 }
}