package pl.coderslab.Service.implementation;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.AuthorDao;
import pl.coderslab.DAO.BookDao;
import pl.coderslab.Repository.AuthorRepository;
import pl.coderslab.Service.AuthorService;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao dao;
    private final BookDao bookDao;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorDao dao, BookDao bookDao, AuthorRepository authorRepository) {
	this.dao = dao;
	this.bookDao = bookDao;
	this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto save(AuthorDto dto) {
	Author author = toAuthorEntity(dto);
	dao.saveToDB(author);
	return author.toDto();
    }

    @Override
    public AuthorDto update(AuthorDto dto) {
	Author author = toAuthorEntity(dto);
	dao.updateEntity(author);
	return author.toDto();
    }

    @Override
    public AuthorDto find(Long id) {

	return dao.findById(id).toDto();
    }

    @Override
    public void remove(Long id) {
	Author author = dao.findById(id);
	dao.delete(author);
    }

    @Override
    public Collection<AuthorDto> getAll() {
	return dao.findAll().stream().filter(Objects::nonNull).map(Author::toDto).collect(Collectors.toList());
    }

    public Author toAuthorEntity(AuthorDto dto) {
	Author author = new Author();
	author.setId(dto.getId());
	author.setFirstName(dto.getFirstName());
	author.setLastName(dto.getLastName());
	if (dto.getPesel() != null) {
	    author.setPesel(dto.getPesel());
	}
	if (dto.getEmail() != null) {
	    author.setEmail(dto.getEmail());
	}
	if (dto.getYearOfBirth() != null) {
	    author.setYearOfBirth(dto.getYearOfBirth());
	}

	if (Objects.nonNull(dto.getBooks()) && !dto.getBooks().isEmpty()) {
	    author.setBooks(
		    dto.getBooks().stream().map(el -> bookDao.findById(el.getId())).collect(Collectors.toSet()));
	}
	return author;
    }

    @Override
    public AuthorDto findByEmail(String email) {
	return authorRepository.findByEmail(email).toDto();
    }

    @Override
    public AuthorDto findByPesel(String pesel) {
	return authorRepository.findByPesel(pesel).toDto();
    }

    @Override
    public Collection<AuthorDto> findByLastName(String lastName) {
	return authorRepository.findByLastName(lastName).stream().filter(Objects::nonNull).map(Author::toDto)
		.collect(Collectors.toList());
    }
}
