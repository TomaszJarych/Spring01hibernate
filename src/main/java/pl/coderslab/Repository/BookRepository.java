package pl.coderslab.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    Collection<Book> findBooksByTitle(String title);
    
    Collection<Book> findBooksByCategory(Category category);
    
    Collection<Book> findBooksByCategoryId(Long id);
    
    Collection<Book> findBooksByAuthorsId(Long id);
    
    Collection<Book> findBooksByAuthors(Author author);
}
