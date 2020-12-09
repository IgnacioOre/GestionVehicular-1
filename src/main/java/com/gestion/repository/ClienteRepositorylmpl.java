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

import com.gestion.model.Cliente;
import com.gestion.model.Producto;

@Repository
public class ClienteRepositorylmpl implements ClienteRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		return this.em.createQuery("SELECT cliente FROM Cliente cliente").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findByNombre(String nombre) throws DataAccessException {
		Query query = this.em.createQuery("SELECT DISTINCT cliente FROM Cliente cliente WHERE cliente.nombre LIKE :nombre");
		query.setParameter("nombre", nombre + "%");
		return query.getResultList();
	}
	
	@Override
	public <S extends Cliente> S save(S entity) {
		em.persist(entity);
		return entity;
	}
	
	@Override
	public List<Cliente> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Cliente> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Cliente> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
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
	public void delete(Cliente entity) {
		Cliente borrado = em.find(Cliente.class, entity.getRut());
		this.em.remove(borrado);
	}

	@Override
	public void deleteAll(Iterable<? extends Cliente> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Cliente> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Cliente> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cliente findByRut(String rut) throws DataAccessException {
		Query query = this.em.createQuery("SELECT DISTINCT cliente FROM Cliente cliente WHERE cliente.rut = :rut");
		query.setParameter("rut", rut);
		return (Cliente) query.getResultList().get(0);
	}

	@Override
	public Cliente merge(Cliente cliente) {
		return em.merge(cliente);
	}



}
