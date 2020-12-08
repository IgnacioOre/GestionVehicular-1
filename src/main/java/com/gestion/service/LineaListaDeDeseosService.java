package com.gestion.service;

import java.util.List;

import com.gestion.model.LineaListaDeDeseos;

public interface LineaListaDeDeseosService {

	void save(LineaListaDeDeseos ldd) throws Exception;
	
	public List<LineaListaDeDeseos> getAllList();
}
