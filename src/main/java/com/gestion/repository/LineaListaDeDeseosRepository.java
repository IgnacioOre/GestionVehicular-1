package com.gestion.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.model.LineaListaDeDeseos;


public interface LineaListaDeDeseosRepository extends JpaRepository<LineaListaDeDeseos, Integer>{
	List <LineaListaDeDeseos> getAllList() throws DataAccessException;
	void merge(LineaListaDeDeseos ldd);
}
