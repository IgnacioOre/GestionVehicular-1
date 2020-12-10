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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Producto {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column(name = "marca", length = 50)
	private String marca;
	
	@Column(name = "modelo", length = 50)
	private String modelo;
	
	@Column(name = "precio")
	private int precio;
	
	@Column(name = "stock")
	private int stock;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_categoria")
    @JsonBackReference
	private Categoria cat;
	
	@ManyToMany(mappedBy = "productos", cascade = CascadeType.ALL)
	private List<LineaListaDeDeseos> lineas;
	
	@ManyToMany(mappedBy = "productos_por_tienda")
	private List<Tienda> tiendas;
	

	public Producto(int id, String nombre, String marca, String modelo, int precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Producto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCat() {
		return cat;
	}

	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	
	
}
