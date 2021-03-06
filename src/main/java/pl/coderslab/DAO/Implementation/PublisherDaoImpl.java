package pl.coderslab.DAO.Implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.DAO.PublisherDao;
import pl.coderslab.entity.Publisher;

@Component
@Transactional
public class PublisherDaoImpl extends AbstractDAO<Publisher , Long> implements PublisherDao {

	@Override
	public Publisher findById(Long id) {
		return entityManager.find(Publisher.class, id);
	}

	@Override
	public Collection<Publisher> findAll() {
		 return entityManager.createQuery("SELECT p FROM Publisher p")
				.getResultList();
	}
	
}
