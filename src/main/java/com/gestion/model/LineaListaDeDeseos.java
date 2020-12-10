package com.gestion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class LineaListaDeDeseos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_linea;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
	private List<Producto> productos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_lista")
	@JsonBackReference
	private ListaDeDeseo listaDeseo;
	
	@Column(name = "nombre_subcat")
	private String nombre;

	// Constructor para pruebas unitarias
	public LineaListaDeDeseos(int id_linea, List<Producto> productos, ListaDeDeseo listaDeseo, String nombre) {
		super();
		this.id_linea = id_linea;
		this.productos = productos;
		this.listaDeseo = listaDeseo;
		this.nombre = nombre;
	}
	
	public LineaListaDeDeseos() {}

	public int getId_linea() {
		return id_linea;
	}

	public void setId_linea(int id_linea) {
		this.id_linea = id_linea;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public ListaDeDeseo getListaDeseo() {
		return listaDeseo;
	}

	public void setListaDeseo(ListaDeDeseo listaDeseo) {
		this.listaDeseo = listaDeseo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addProducto(Producto producto) {
		productos.add(producto);
		
	}	
}