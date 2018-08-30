package pl.coderslab.DAO.Implementation;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public abstract class AbstractDAO<E, I extends Serializable>  {

	@PersistenceContext
	protected EntityManager entityManager;

	public E saveToDB(E entity) {
		entityManager.persist(entity);
		return entity;
	}
	
	public E updateEntity (E entity) {
		
		entityManager.merge(entity);
		
		return entity;
	}
	
	public void delete(E entity) {
		entityManager.remove(entityManager.contains(entity)? entity : entityManager.merge(entity));
		
	}
}
