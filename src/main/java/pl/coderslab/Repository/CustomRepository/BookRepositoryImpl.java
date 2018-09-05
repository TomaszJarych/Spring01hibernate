package pl.coderslab.Repository.CustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceUnit
    private EntityManagerFactory emFactory;

    // problem z błędem TransactionRequiredException:
    @Override
    public void resetRating(int rating) {

	EntityManager em = emFactory.createEntityManager();
	em.getTransaction().begin();
	Query queryp = em.createQuery("UPDATE Book b SET b.rating =:rating");
	queryp.setParameter("rating", rating).executeUpdate();
	em.getTransaction().commit();
	em.close();
    }

}
