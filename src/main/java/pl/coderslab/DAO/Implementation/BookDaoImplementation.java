package pl.coderslab.DAO.Implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.DAO.BookDao;
import pl.coderslab.entity.Book;

@Component
@Transactional
public class BookDaoImplementation extends AbstractDAO<Book, Long> implements BookDao {

    @Override
    public Book findById(Long id) {

	return entityManager.find(Book.class, id);
    }

    @Override
    public Collection<Book> findAll() {
	return entityManager.createQuery("SELECT b From Book b").getResultList();
    }

    @Override
    public Collection<Book> getAllPropositions() {
	return entityManager.createQuery("SELECT b From Book b WHERE b.proposition = true").getResultList();
    }
}
