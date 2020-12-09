package com.gestion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ListaDeDeseo {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre", length = 150)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cliente")
    @JsonBackReference
	private Cliente cliente;
	
	@OneToMany(mappedBy = "listaDeseo")
	private List<LineaListaDeDeseos> lineaLista;
	
	// Constructor para pruebas unitarias
	public ListaDeDeseo() {}
	
	public ListaDeDeseo(int id, String nombre, Cliente cliente) {
		this.id = id;
		this.name = nombre;
		this.cliente = cliente;
	}	

	
	public ListaDeDeseo(int id, String name, Cliente cliente, List<LineaListaDeDeseos> lineaLista) {
		super();
		this.id = id;
		this.name = name;
		this.cliente = cliente;
		this.lineaLista = lineaLista;
	}
	
	

	public ListaDeDeseo() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// getter y setter para prueba unitaria
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}		
}