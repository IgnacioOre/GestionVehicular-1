package com.gestion.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataRetrievalFailureException;

import com.gestion.model.Producto;
import com.gestion.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {
	
	@Mock
	private ProductoRepository productoRepository;
	
	@InjectMocks
	private ProductoServiceImpl productoService;
	
	@Test
	void siSeInvocaDeleteConUnProductoValidoYNoSePuedeBorrarLanzaException() {
	    ////Arrange
	    Producto producto= new Producto (2,"Espejo Derecho","TYC","73Y25",12490,20);
	    doThrow(DataRetrievalFailureException.class).when(productoRepository).delete(producto);

	    //Act + Assert
	    assertThrows(Exception.class,()->productoService.delete(2));
	}
	
	@Test
	void siSeInvocaSaveConUnProductoValidoYNoSePuedeGuardarLanzaException() {
	    ////Arrange
	    Producto producto= new Producto (2,"Espejo Derecho","TYC","73Y25",12490,20);
	    doThrow(DataRetrievalFailureException.class).when(productoRepository).save(producto);

	    //Act + Assert
	    assertThrows(Exception.class,()->productoService.save(producto));
	}	
	
	@Test
	void siSeInvocaGetAllProductoDebeRetornarListaProducto() {
	    //Arrange
	    ArrayList<Producto> productos= new ArrayList<Producto>();
	    productos.add(new Producto (1,"Neumatico","Hankook","k415",70990,24));
	    productos.add(new Producto (2,"Espejo Derecho","TYC","73Y25",12490,20));
	    productos.add(new Producto (3,"Condensador","NEW ERA","4NC-87",1990,10));
	    when(productoService.getAllProductos()).thenReturn(productos);
	    List<Producto> resultado;

	    //Act
	    resultado = productoService.getAllProductos();

	    //Assert
	    assertNotNull(resultado);
	    assertEquals(productos.size(),resultado.size());
	    assertEquals("Neumatico", resultado.get(0).getNombre());
	    assertEquals(1, resultado.get(0).getId());
	    assertAll("resultado",
	            () -> assertEquals("Neumatico",resultado.get(0).getNombre()),
	            () -> assertEquals(70990,resultado.get(0).getPrecio()),
	            () -> assertEquals("Espejo Derecho",resultado.get(1).getNombre()),
	            () -> assertEquals("NEW ERA", resultado.get(2).getMarca())
	            );
	}
	
	@Test
	void siSeInvocaGetAllProductoYNoExistenProductosDevuelveUnaListaVacia() {
	    //Arrange
	    when (productoService.getAllProductos()).thenReturn(new ArrayList<Producto>());
	    List<Producto> resultado;

	    //Act
	    resultado = productoService.getAllProductos();

	    //Assert
	    assertNotNull(resultado);
	    assertEquals(0,resultado.size());    
	}	
	
	@Test 
	void siSeInvocaFindByNombreDebeRetornarUnProducto() {    

	    // Arrange
	    Producto producto = new Producto(2, "Bujia", "Hufman", "GJK5S", 1200, 25);
	    when(productoRepository.findByNombre("Bujia")).thenReturn(producto);
	    Producto resultado;

	    // Act
	    resultado = productoService.findByNombre("Bujia");

	    // Assert
	    assertNotNull(resultado);
	    assertThat(resultado.getId()).isEqualTo(producto.getId());
	    assertThat(resultado.getNombre()).isEqualTo(producto.getNombre());    
	}
	
	@Test
	void siSeInvocaFindByIdDebeRetornarUnProducto() {        

	    // Arrange
	    Producto producto = new Producto(2, "Bujia", "Hufman", "GJK5S", 1200, 25);
	    when(productoRepository.findById(2)).thenReturn(producto);
	    Producto resultado;

	    // Act
	    resultado = productoService.findByInt(2);

	    // Assert
	    assertNotNull(resultado);
	    assertThat(resultado.getId()).isEqualTo(producto.getId());
	    assertThat(resultado.getNombre()).isEqualTo(producto.getNombre());   
	}
}