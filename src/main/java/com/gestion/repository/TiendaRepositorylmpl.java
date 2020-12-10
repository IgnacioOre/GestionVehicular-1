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

import com.gestion.model.Producto;
import com.gestion.model.Tienda;

@Repository
public class TiendaRepositorylmpl implements TiendaRepository {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")

	@Override
	public List<Tienda> findAll() {
		// TODO Auto-generated method stub
		return this.em.createQuery("Select tienda FROM Tienda tienda").getResultList();

	}

	@Override
	public List<Tienda> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tienda> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tienda> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Tienda> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Tienda> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Tienda getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tienda> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tienda> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Tienda> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tienda> S save(S entity) {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Optional<Tienda> findById(Integer id) {
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
	public void delete(Tienda entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Tienda> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Tienda> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tienda> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tienda> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Tienda> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tienda findTiendaById(int id) {
		Query query = this.em.createQuery("SELECT DISTINCT tienda FROM Tienda tienda WHERE tienda.id = :id");
        query.setParameter("id", id );
        return (Tienda) query.getResultList().get(0);
	}

	@Override
	public List<Tienda> findByNombre(String nombre) throws DataAccessException {
		Query query = this.em.createQuery("SELECT DISTINCT tienda FROM Tienda tienda WHERE tienda.nombre LIKE :nombre");
		query.setParameter("nombre", "%" + nombre + "%");
		List<Tienda> resultList = (List<Tienda>) query.getResultList();
		return resultList;
	}
	
	@Override
	public List<Tienda> findByCiudad(String ciudad) throws DataAccessException {
		Query query = this.em.createQuery("SELECT DISTINCT tienda FROM Tienda tienda WHERE tienda.ciudad LIKE :ciudad");
		query.setParameter("ciudad", "%" + ciudad + "%");
		List<Tienda> resultList = (List<Tienda>) query.getResultList();
		return resultList;
	}
	
	public void merge(Tienda tienda) {
		em.merge(tienda);
	}

}
