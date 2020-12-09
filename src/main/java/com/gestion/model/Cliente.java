package com.gestion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String direccion,
			String email) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.direccion = direccion;
		this.email = email;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	private String rut;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column(name = "apellidoPaterno", length = 50)
	private String apellidoPaterno;
	
	@Column(name = "apellidoMaterno", length = 50)
	private String apellidoMaterno;
	
	@Column(name = "direccion", length = 50)
	private String direccion;
	
	@Column(name = "email", length = 50)
	private String email;
	
	@OneToMany(mappedBy = "cliente")
	private List<ListaDeDeseo> listasDeDeseo;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}