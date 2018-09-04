package pl.coderslab.Service;

import java.util.Collection;

import pl.coderslab.dto.AuthorDto;
import pl.coderslab.dto.BookDto;
import pl.coderslab.dto.CategoryDTO;

public interface BookService extends BaseCRUD<BookDto, Long> {
    Collection<BookDto> getAllPropositions();

    long getBookCount();

    Collection<BookDto> findBooksByTitle(String title);

    Collection<BookDto> findBooksByCategory(CategoryDTO category);
    
    Collection<BookDto> findBooksByCategoryID(Long id);
    
    Collection<BookDto> findBooksByAuthorId(Long id);
    
    Collection<BookDto> findBooksByAuthors(AuthorDto authorDto);

}
