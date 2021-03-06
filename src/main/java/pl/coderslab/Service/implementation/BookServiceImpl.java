package pl.coderslab.Service.implementation;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.AuthorDao;
import pl.coderslab.DAO.BookDao;
import pl.coderslab.DAO.CategoryDao;
import pl.coderslab.DAO.PublisherDao;
import pl.coderslab.Repository.BookRepository;
import pl.coderslab.Service.BookService;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.dto.BookDto;
import pl.coderslab.dto.CategoryDTO;
import pl.coderslab.dto.PublisherDto;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao dao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryDao categoryDao;

    @Autowired
    public BookServiceImpl(BookDao dao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository,
	    CategoryDao categoryDao) {
	this.dao = dao;
	this.publisherDao = publisherDao;
	this.authorDao = authorDao;
	this.bookRepository = bookRepository;
	this.categoryDao = categoryDao;
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

	return dao.findAll().stream().filter(Objects::nonNull).map(Book::toDto).collect(Collectors.toList());
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
	if (dto.isProposition() == false) {
	    Publisher publisher = publisherDao.findById(dto.getPublisherDto().getId());
	    book.setPublisher(publisher);

	}

	if (dto.getCategory() != null) {
	    book.setCategory(categoryDao.findById(dto.getCategory().getId()));
	}

	book.setRating(dto.getRating());
	book.setTitle(dto.getTitle());
	book.setPages(dto.getPages());
	book.setProposition(dto.isProposition());

	return book;
    }

    private Book updateEntity(BookDto dto) {
	Book book = dao.findById(dto.getId());
	book.setTitle(dto.getTitle());
	book.setDescription(dto.getDescription());
	book.setRating(dto.getRating());
	book.setPages(dto.getPages());
	book.setProposition(dto.isProposition());
	if (dto.getCategory() != null) {
	    book.setCategory(categoryDao.findById(dto.getCategory().getId()));
	}
	if (dto.isProposition() == false) {
	    book.setPublisher(publisherDao.findById(dto.getPublisherDto().getId()));
	}

	if (Objects.nonNull(dto.getAuthors()) && !dto.getAuthors().isEmpty()) {
	    book.getAuthors().clear();
	    dto.getAuthors().stream().map(el -> authorDao.findById(el.getId()))
		    .forEach(el -> book.getAuthors().add(el));
	}

	return book;
    }
    // private void addRelations(BookDto dto, Book book) {
    // if (Objects.nonNull(dto.getAuthors()) && !dto.getAuthors().isEmpty()) {
    // book.getAuthors().clear();
    // for (AuthorDto auth : dto.getAuthors()) {
    // Author author = authorDao.findById(auth.getId());
    // if (Objects.nonNull(author)) {
    // book.getAuthors().add(author);
    // }
    // }
    // }
    // if (Objects.nonNull(dto.getPublisherDto())) {
    // Publisher publisher = publisherDao
    // .findById(dto.getPublisherDto().getId());
    // if (Objects.nonNull(publisher)) {
    // book.setPublisher(publisher);
    // }
    // }
    // }

    @Override
    public Collection<BookDto> getAllPropositions() {
	return dao.getAllPropositions().stream().filter(Objects::nonNull).map(Book::toDto).collect(Collectors.toList());
    }

    @Override
    public long getBookCount() {
	return bookRepository.count();
    }

    @Override
    public Collection<BookDto> findBooksByTitle(String title) {
	return bookRepository.findBooksByTitle(title).stream().filter(Objects::nonNull).map(Book::toDto)
		.collect(Collectors.toList());
    }

    @Override
    public Collection<BookDto> findBooksByCategory(CategoryDTO category) {
	Category categoryToFind = categoryDao.findById(category.getId());

	return bookRepository.findBooksByCategory(categoryToFind).stream().filter(Objects::nonNull).map(Book::toDto)
		.collect(Collectors.toList());
    }

    @Override
    public Collection<BookDto> findBooksByCategoryID(Long id) {
	return bookRepository.findBooksByCategoryId(id).stream().filter(Objects::nonNull).map(Book::toDto)
		.collect(Collectors.toList());
    }

    @Override
    public Collection<BookDto> findBooksByAuthorId(Long id) {
	return collectionConverse(bookRepository.findBooksByAuthorsId(id));

    }

    @Override
    public Collection<BookDto> findBooksByAuthors(AuthorDto authorDto) {
	Author author = authorDao.findById(authorDto.getId());

	return collectionConverse(bookRepository.findBooksByAuthors(author));
    }

    @Override
    public Collection<BookDto> findBooksByPublisher(PublisherDto dto) {
	return collectionConverse(bookRepository.findBooksByPublisher(publisherDao.findById(dto.getId())));
    }

    @Override
    public Collection<BookDto> findBooksByRating(Integer rating) {
	
	return collectionConverse(bookRepository.findBooksByRating(rating));
    }
    
    @Override
    public BookDto findFirstBookByCategoryOrderByTitleAsc(CategoryDTO dto) {
	Category category = categoryDao.findById(dto.getId());
	return bookRepository.findFirstBookByCategoryOrderByTitleAsc(category).toDto();
    }

    private Collection<BookDto> collectionConverse(Collection<Book> collection) {
	return collection.stream().filter(Objects::nonNull).map(Book::toDto).collect(Collectors.toList());
    }

    @Override
    public Collection<BookDto> findAllBooksByTitleQuery(String title) {
	return collectionConverse(bookRepository.findAllBooksByTitleQuery(title));
    }

    @Override
    public Collection<BookDto> findAllBooksByCategoryQuery(CategoryDTO categoryDTO) {
	Category category = categoryDao.findById(categoryDTO.getId());
	
	return collectionConverse(bookRepository.findAllBooksByCategoryQuery(category));
    }

    @Override
    public Collection<BookDto> findAllBooksByBetweenRating(Integer rating1, Integer rating2) {
	return collectionConverse(bookRepository.findAllBooksByBetweenRating(rating1, rating2));
    }

    @Override
    public Collection<BookDto> findAllBooksByPublisherQuery(PublisherDto dto) {
	Publisher publisher = publisherDao.findById(dto.getId());
	
	return collectionConverse(bookRepository.findAllBooksByPublisherQuery(publisher));
    }

    @Override
    public BookDto findFirstBookByCategorySortedByTitleQuery(CategoryDTO categoryDTO) {
	Category category = categoryDao.findById(categoryDTO.getId());
	
	return bookRepository.findFirstBookByCategorySortedByTitleQuery(category).toDto();
    }

    @Override
    public void setRatingToAllBooks(int rating) {
	bookRepository.resetRating(rating);
	
    }
    
    
    
    
    
}
