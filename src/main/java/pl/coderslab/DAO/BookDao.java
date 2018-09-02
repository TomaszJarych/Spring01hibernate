package pl.coderslab.DAO;

import java.util.Collection;

import pl.coderslab.entity.Book;
public interface BookDao extends BaseDAO<Book, Long> {
    
    Collection<Book> getAllPropositions();

}
