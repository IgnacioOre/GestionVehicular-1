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

@Entity
public class LineaListaDeDeseos {
	
	

	public LineaListaDeDeseos(int i, List<ListaDeDeseo> listasDeseo, ListaDeDeseo deseoList, String string) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_linea;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
	private List<Producto> productos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_lista")
	private ListaDeDeseo listaDeseo;
	
	@Column(name = "nombre_subcat")
	private String nombre;
}
