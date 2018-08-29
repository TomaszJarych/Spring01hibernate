package pl.coderslab.DAO.Implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.DAO.PersonDetailDao;
import pl.coderslab.entity.PersonDetail;
@Component
@Transactional
public class PersonDetailDaoImpl extends AbstractDAO<PersonDetail, Long>  implements PersonDetailDao {

	@Override
	public PersonDetail findById(Long id) {
		return entityManager.find(PersonDetail.class, id);
	}

	@Override
	public Collection<PersonDetail> findAll() {
		return entityManager.createQuery("SELECT pd FROM PersonDetail pd")
				.getResultList();
	}

}
