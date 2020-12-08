package com.gestion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Categoria {

	// hola
	@Id
	@Column(name = "id_cat")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_cat")
	private String nombre_cat;
	
	@OneToMany(mappedBy = "cat")
	private List<Producto> productos;
	
	public Categoria(int id) {
		this.id = id;
	}
	
	public Categoria() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_cat() {
		return nombre_cat;
	}

	public void setNombre_cat(String nombre_cat) {
		this.nombre_cat = nombre_cat;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto producto) {
		getProductos().add(producto);
	}
	
}
