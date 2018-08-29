package pl.coderslab.DAO.Implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.DAO.PublisherDao;
import pl.coderslab.dto.PublisherDto;
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
