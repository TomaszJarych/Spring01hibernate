package pl.coderslab.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    Author findByEmail(String email);
    
    Author findByPesel(String pesel);
    
    Collection<Author> findByLastName(String lastName);
    
    @Query("SELECT a FROM Author a WHERE a.email LIKE :beginning%")
    Collection<Author> findByEmailBeginningQuery(@Param("beginning")String beginning);
    
    @Query("SELECT a FROM Author a WHERE a.pesel LIKE :beginning%")
    Collection<Author> findByPeselBeginningWithQuery(@Param("beginning")String beginning);

}

