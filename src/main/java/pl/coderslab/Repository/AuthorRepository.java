package pl.coderslab.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    Author findByEmail(String email);
    Author findByPesel(String pesel);
    Collection<Author> findByLastName(String lastName);

}
