package com.gestion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import com.gestion.model.Producto;
import com.gestion.model.Tienda;
import com.gestion.repository.TiendaRepository;

@ExtendWith(MockitoExtension.class)
public class TiendaServiceTest {

	@Mock
	private TiendaRepository tiendaRepository;

	@InjectMocks
	private TiendaServiceImpl tiendaServiceImpl;

	@Test
	void siSeInvocaGetAllTiendaRetornaLista() {

		ArrayList<Tienda> tienda = new ArrayList<Tienda>();
		List<Producto> listprod = new ArrayList<Producto>();

		Producto produc1 = new Producto(1, "prod", "Intel", "i5", 200000, 5);
		Tienda tienda1 = new Tienda(1, "PCF", "SanCarlos", listprod);

		listprod.add(produc1);
		tienda.add(tienda1);

		when(tiendaServiceImpl.getAllTiendas()).thenReturn(tienda);

		List<Tienda> resultado;
		resultado = tiendaServiceImpl.getAllTiendas();

		assertNotNull(resultado);
		assertEquals(tienda.size(), resultado.size());
	}

	@Test
	void siSeInvocaGetAllTiendaRetornaListaVacia() {
		List<Tienda> tienda = new ArrayList<Tienda>();
		when(tiendaServiceImpl.getAllTiendas()).thenReturn(tienda);
		List<Tienda> resultado;

		resultado = tiendaServiceImpl.getAllTiendas();

		assertNotNull(resultado);
		assertEquals(0, resultado.size());
	}

	@Test
	void siSeInvocaSaveSatisfactoriamente() throws Exception {
		List<Tienda> tienda = new ArrayList<Tienda>();
		List<Producto> listprod = new ArrayList<Producto>();

		Producto produc1 = new Producto(1, "prod", "Intel", "i5", 200000, 5);
		listprod.add(produc1);
		Tienda tienda1 = new Tienda(1, "PCF", "SanCarlos", listprod);
		tienda.add(tienda1);

		tiendaServiceImpl.save(tienda1);
		Mockito.verify(tiendaRepository, times(1)).save(tienda1);
	}

	@Test
	void siSeInvocaSaveYLanzaException() {
		assertThrows(Exception.class, () -> tiendaServiceImpl.save(null));
	}
}