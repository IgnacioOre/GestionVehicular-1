package com.gestion.model;

import java.util.List;

import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany; */
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;




@Entity
public class Tienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column (name = "ciudad", length = 50)
	private String ciudad;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
	private List<Producto> productos_por_tienda;
	
	public Tienda() {
		
	}
	
	public int getId() {
		return id;
	}

	
	public Tienda(int id, String nombre, String ciudad, List<Producto> productos_por_tienda) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.productos_por_tienda = productos_por_tienda;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public List<Producto> getProductos_por_tienda() {
		return productos_por_tienda;
	}


	public void setProductos_por_tienda(List<Producto> productos_por_tienda) {
		this.productos_por_tienda = productos_por_tienda;
	}


	public void addProducto(Producto producto) {
		this.productos_por_tienda.add(producto);
	}

	public void deleteProductoById(int id2) {
		for (int i=0;i<productos_por_tienda.size();i++) {
			if (productos_por_tienda.get(i).getId() == id2) {
				productos_por_tienda.remove(i);
			}
		}
		
	}
	
	

  	
	
}
