package pl.coderslab.Service;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.stereotype.Service;


public interface BaseCRUD<D, I extends Serializable> {

	public D save(D dto);

	public D update(D dto);

	public D find(I id);
	
	public void remove(I id);
	
	public Collection<D> getAll();

}