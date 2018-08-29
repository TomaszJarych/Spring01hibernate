package pl.coderslab.Service.implementation;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.BookDao;
import pl.coderslab.DAO.PublisherDao;
import pl.coderslab.DAO.Implementation.BookDaoImplementation;
import pl.coderslab.Service.BookService;
import pl.coderslab.dto.BookDto;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
@Service
public class BookServiceImpl implements BookService {

	private final BookDao dao;
	private final PublisherDao publisherDao; 

	@Autowired
	public BookServiceImpl(BookDao dao, PublisherDao publisherDao) {
		this.dao = dao;
		this.publisherDao = publisherDao;
	}

	@Override
	public BookDto save(BookDto dto) {
		Book book = toBookEntity(dto);
		
		dao.saveToDB(book);
		return book.toDto();
	}


	@Override
	public BookDto update(BookDto dto) {
		Book book = toBookEntity(dto);
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
		book.setAuthor(dto.getAuthor());
		book.setDescription(dto.getDescription());
		book.setId(dto.getId());
		
		Publisher publisher = publisherDao.findById(dto.getPublisherDto().getId());
		if (Objects.nonNull(publisher)) {
			book.setPublisher(publisher);
		}
		
		book.setRating(dto.getRating());
		book.setTitle(dto.getTitle());

		return book;
	}
}
