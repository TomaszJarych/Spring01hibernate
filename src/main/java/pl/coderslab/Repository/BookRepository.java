package pl.coderslab.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.Repository.CustomRepository.BookRepositoryCustom;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{

    Collection<Book> findBooksByTitle(String title);

    Collection<Book> findBooksByCategory(Category category);

    Collection<Book> findBooksByCategoryId(Long id);

    Collection<Book> findBooksByAuthorsId(Long id);

    Collection<Book> findBooksByAuthors(Author author);

    Collection<Book> findBooksByPublisher(Publisher publisher);

    Collection<Book> findBooksByRating(Integer rating);

    Book findFirstBookByCategoryOrderByTitleAsc(Category category);

    @Query("Select b FROM Book b where b.title =?1")
    Collection<Book> findAllBooksByTitleQuery(String title);

    @Query("Select b FROM Book b where b.category =?1")
    Collection<Book> findAllBooksByCategoryQuery(Category category);

    @Query("Select b FROM Book b WHERE b.rating BETWEEN ?1 and ?2")
    Collection<Book> findAllBooksByBetweenRating(Integer rating1, Integer rating2);

    @Query("Select b FROM Book b WHERE b.publisher = ?1")
    Collection<Book> findAllBooksByPublisherQuery(Publisher publisher);

    @Query(value = "Select * From books where category_id = ?1 order by title asc Limit 1", nativeQuery = true)
    Book findFirstBookByCategorySortedByTitleQuery(Category category);
}
