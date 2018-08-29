package pl.coderslab.Service.implementation;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.AuthorDao;
import pl.coderslab.Service.AuthorService;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorDao dao;

	@Autowired
	public AuthorServiceImpl(AuthorDao dao) {
		this.dao = dao;
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
		return dao.findAll().stream().filter(Objects::nonNull)
				.map(Author::toDto).collect(Collectors.toList());
	}

	public Author toAuthorEntity(AuthorDto dto) {
		Author author = new Author();
		author.setId(dto.getId());
		author.setFirstName(dto.getFirstName());
		author.setLastName(dto.getLastName());

		return author;
	}

}
