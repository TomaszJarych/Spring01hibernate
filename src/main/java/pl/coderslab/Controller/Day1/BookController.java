package pl.coderslab.Controller.Day1;

import java.util.Collection;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.BookService;
import pl.coderslab.Service.PublisherService;
import pl.coderslab.dto.BookDto;
import pl.coderslab.dto.PublisherDto;

@Controller
@RequestMapping("/day1")
public class BookController {

	private final BookService bookService;
	private final PublisherService publisherService;

	@Autowired
	public BookController(BookService bookService,
			PublisherService publisherService) {
		this.bookService = bookService;
		this.publisherService = publisherService;
	}

	@RequestMapping(path = "/addBook", method = RequestMethod.GET)
	@ResponseBody
	public String getBook() {
		BookDto dto = new BookDto();
		dto.setAuthor("Jan Kowalski");
		dto.setDescription("Programming");
		PublisherDto publisherDto = publisherService.find(1L);
		dto.setPublisherDto(publisherDto);
		dto.setRating(5);
		dto.setTitle("Streams basics");

		bookService.save(dto);

		return "Book has been added";
	}

	@RequestMapping(path = "/getBook/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BookDto getBookByID(@PathVariable("id") Long id) {

		BookDto book = bookService.find(id);

		return book;
	}

	@RequestMapping(path = "/updateBook/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateBook(@PathVariable("id") Long id) {

		BookDto book = bookService.find(id);
		book.setAuthor("Adam Nowak");
		System.out.println(book);
		bookService.update(book);

		return "The book has been updated";
	}

	@RequestMapping(path = "/deleteBook/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteBook(@PathVariable("id") Long id) {

		bookService.remove(id);

		return "book has been deleted";
	}

	@RequestMapping(path = "/getAllBooks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<BookDto> getAllBooks() {

		return bookService.getAll();

	}

}
