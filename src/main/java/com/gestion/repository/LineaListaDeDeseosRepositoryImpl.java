package com.gestion.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.gestion.model.LineaListaDeDeseos;

@Repository
public class LineaListaDeDeseosRepositoryImpl implements LineaListaDeDeseosRepository{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LineaListaDeDeseos> getAllList() throws DataAccessException {
		Query query = this.em.createQuery("SELECT LineaLineaListaDeDeseoss FROM LineaListaDeDeseos LineaListaDeDeseos");		
		return query.getResultList();		
	}
	
	@Override
	public <S extends LineaListaDeDeseos> S save(S entity) {
		em.persist(entity);
		return entity;
	}
	
	@Override
	public List<LineaListaDeDeseos> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineaListaDeDeseos> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineaListaDeDeseos> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LineaListaDeDeseos> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends LineaListaDeDeseos> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<LineaListaDeDeseos> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LineaListaDeDeseos getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LineaListaDeDeseos> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LineaListaDeDeseos> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<LineaListaDeDeseos> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public Optional<LineaListaDeDeseos> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LineaListaDeDeseos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends LineaListaDeDeseos> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends LineaListaDeDeseos> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LineaListaDeDeseos> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LineaListaDeDeseos> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends LineaListaDeDeseos> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void merge(LineaListaDeDeseos lineaListaDeDeseos) {
		em.merge(lineaListaDeDeseos);
	}
}
