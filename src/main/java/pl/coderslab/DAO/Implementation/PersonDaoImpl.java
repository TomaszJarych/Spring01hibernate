package pl.coderslab.DAO.Implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.DAO.PersonDao;
import pl.coderslab.entity.Person;

@Component
@Transactional
public class PersonDaoImpl extends AbstractDAO<Person, Long>
		implements
			PersonDao {

	@Override
	public Person findById(Long id) {
		return entityManager.find(Person.class, id);
	}

	@Override
	public Collection<Person> findAll() {
		return entityManager.createQuery("SELECT p FROM Person p")
				.getResultList();
	}

}
