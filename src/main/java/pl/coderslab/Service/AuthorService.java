package pl.coderslab.Service;

import java.util.Collection;

import pl.coderslab.dto.AuthorDto;

public interface AuthorService extends BaseCRUD<AuthorDto, Long>{
    
    AuthorDto findByEmail(String email);
    AuthorDto findByPesel(String pesel);
    Collection<AuthorDto> findByLastName(String lastName);
    
    Collection<AuthorDto> findByEmailBeginningQuery(String beginning);
    
    Collection<AuthorDto> findByPeselBeginningWithQuery(String beginning);

}
