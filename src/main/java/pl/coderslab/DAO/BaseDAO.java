package pl.coderslab.DAO;

import java.io.Serializable;
import java.util.Collection;

public interface BaseDAO<E, I extends Serializable> {

	public E saveToDB(E entity);

	public E updateEntity(E entity);

	public E findById(I id);

	public void delete(E entity);

	public Collection<E> findAll();

}
