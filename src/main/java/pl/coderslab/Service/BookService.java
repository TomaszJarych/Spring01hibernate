package pl.coderslab.Service;

import java.util.Collection;

import pl.coderslab.dto.AuthorDto;
import pl.coderslab.dto.BookDto;
import pl.coderslab.dto.CategoryDTO;
import pl.coderslab.dto.PublisherDto;

public interface BookService extends BaseCRUD<BookDto, Long> {
    Collection<BookDto> getAllPropositions();

    long getBookCount();

    Collection<BookDto> findBooksByTitle(String title);

    Collection<BookDto> findBooksByCategory(CategoryDTO category);
    
    Collection<BookDto> findBooksByCategoryID(Long id);
    
    Collection<BookDto> findBooksByAuthorId(Long id);
    
    Collection<BookDto> findBooksByAuthors(AuthorDto authorDto);
    
    Collection<BookDto> findBooksByPublisher(PublisherDto dto);
    
    Collection<BookDto> findBooksByRating(Integer rating);
    
    BookDto findFirstBookByCategoryOrderByTitleAsc(CategoryDTO dto);
    
    Collection<BookDto> findAllBooksByTitleQuery(String title);
    
    Collection<BookDto> findAllBooksByCategoryQuery(CategoryDTO category);
    
    Collection<BookDto> findAllBooksByBetweenRating(Integer rating1, Integer rating2);
    
    Collection<BookDto> findAllBooksByPublisherQuery(PublisherDto dto);
    
    BookDto findFirstBookByCategorySortedByTitleQuery(CategoryDTO categoryDTO);
    
    void setRatingToAllBooks(int rating);

}
