package pl.coderslab.Service;

import java.util.Collection;

import pl.coderslab.dto.BookDto;

public interface BookService extends BaseCRUD<BookDto, Long> {
    Collection<BookDto> getAllPropositions();

}
