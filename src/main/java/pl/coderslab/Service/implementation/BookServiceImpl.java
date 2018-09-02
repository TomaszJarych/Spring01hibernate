package pl.coderslab.Service.implementation;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.AuthorDao;
import pl.coderslab.DAO.BookDao;
import pl.coderslab.DAO.PublisherDao;
import pl.coderslab.Service.BookService;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.dto.BookDto;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
@Service
public class BookServiceImpl implements BookService {

	private final BookDao dao;
	private final PublisherDao publisherDao;
	private final AuthorDao authorDao;

	@Autowired
	public BookServiceImpl(BookDao dao, PublisherDao publisherDao,
			AuthorDao authorDao) {
		this.dao = dao;
		this.publisherDao = publisherDao;
		this.authorDao = authorDao;
	}

	@Override
	public BookDto save(BookDto dto) {
		Book book = toBookEntity(dto);

		dao.saveToDB(book);
		return book.toDto();
	}

	@Override
	public BookDto update(BookDto dto) {
		Book book = updateEntity(dto);
		dao.updateEntity(book);
		return book.toDto();
	}

	@Override
	public BookDto find(Long id) {

		return dao.findById(id).toDto();
	}

	@Override
	public void remove(Long id) {
		Book book = dao.findById(id);
		dao.delete(book);

	}

	@Override
	public Collection<BookDto> getAll() {

		return dao.findAll().stream().filter(Objects::nonNull).map(Book::toDto)
				.collect(Collectors.toList());
	}

	public Book toBookEntity(BookDto dto) {
		Book book = new Book();
		if (Objects.nonNull(dto.getAuthors()) && !dto.getAuthors().isEmpty()) {
			for (AuthorDto authorDto : dto.getAuthors()) {
				Author author = authorDao.findById(authorDto.getId());
				if (Objects.nonNull(author)) {
					book.getAuthors().add(author);
				}
			}

		}
		book.setDescription(dto.getDescription());
		book.setId(dto.getId());

		Publisher publisher = publisherDao
				.findById(dto.getPublisherDto().getId());
		if (Objects.nonNull(publisher)) {
			book.setPublisher(publisher);
		}

		book.setRating(dto.getRating());
		book.setTitle(dto.getTitle());
		book.setPages(dto.getPages());

		return book;
	}

	private Book updateEntity(BookDto dto) {
		Book book = dao.findById(dto.getId());
		book.setTitle(dto.getTitle());
		book.setDescription(dto.getDescription());
		book.setRating(dto.getRating());
		book.setPages(dto.getPages());

		book.setPublisher(publisherDao.findById(dto.getPublisherDto().getId()));
		
		if (Objects.nonNull(dto.getAuthors()) && !dto.getAuthors().isEmpty()) {
			book.getAuthors().clear();
			dto.getAuthors().stream()
					.map(el -> authorDao.findById(el.getId()))
					.forEach(el -> book.getAuthors().add(el));
		}

		return book;
	}
//	private void addRelations(BookDto dto, Book book) {
//		if (Objects.nonNull(dto.getAuthors()) && !dto.getAuthors().isEmpty()) {
//			book.getAuthors().clear();
//			for (AuthorDto auth : dto.getAuthors()) {
//				Author author = authorDao.findById(auth.getId());
//				if (Objects.nonNull(author)) {
//					book.getAuthors().add(author);
//				}
//			}
//		}
//		if (Objects.nonNull(dto.getPublisherDto())) {
//			Publisher publisher = publisherDao
//					.findById(dto.getPublisherDto().getId());
//			if (Objects.nonNull(publisher)) {
//				book.setPublisher(publisher);
//			}
//		}
//	}
}
