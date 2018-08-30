package pl.coderslab.DAO.Implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.DAO.AuthorDao;
import pl.coderslab.entity.Author;

@Component
@Transactional
public class AuthorDaoImpl extends AbstractDAO<Author, Long>
		implements
			AuthorDao {

	@Override
	public Author findById(Long id) {

		return entityManager.find(Author.class, id);
	}

	@Override
	public Collection<Author> findAll() {
		return entityManager.createQuery("SELECT a From Author a")
				.getResultList();
	}

}
