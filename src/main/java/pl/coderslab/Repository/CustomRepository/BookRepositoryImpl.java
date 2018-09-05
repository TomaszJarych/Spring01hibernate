package pl.coderslab.Repository.CustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

//    @PersistenceUnit
//    private EntityManagerFactory emFactory;
//    
//    
//
//    // problem z błędem TransactionRequiredException:
//    @Override
//    public void resetRating(int rating) {
//
//	EntityManager em = emFactory.createEntityManager();
//	em.getTransaction().begin();
//	Query queryp = em.createQuery("UPDATE Book b SET b.rating =:rating");
//	queryp.setParameter("rating", rating).executeUpdate();
//	em.getTransaction().commit();
//	em.close();
//    }
    
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void resetRating(int rating) {
	Query queryp = em.createQuery("UPDATE Book b SET b.rating =:rating");
	queryp.setParameter("rating", rating).executeUpdate();
	
    }

}
