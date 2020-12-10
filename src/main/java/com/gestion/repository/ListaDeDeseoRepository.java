package com.gestion.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.model.ListaDeDeseo;


public interface ListaDeDeseoRepository extends JpaRepository<ListaDeDeseo, Integer>{

	List <ListaDeDeseo> getAllList() throws DataAccessException;

	void merge(ListaDeDeseo ldd);
}
