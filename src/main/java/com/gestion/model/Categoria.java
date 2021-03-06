package com.gestion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Categoria {
	@Id
	@Column(name = "id_cat")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_cat")
	private String nombre_cat;
	
	@OneToMany(mappedBy = "cat", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Producto> productos;
	
	public Categoria(int id) {
		this.id = id;
	}
	
	public Categoria() {}
	
	public Categoria(int id, String nombreCat) {
		this.id = id;
		this.nombre_cat = nombreCat;
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
