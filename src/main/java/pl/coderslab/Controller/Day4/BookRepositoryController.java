package pl.coderslab.Controller.Day4;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.AuthorService;
import pl.coderslab.Service.BookService;
import pl.coderslab.Service.CategoryService;
import pl.coderslab.Service.PublisherService;
import pl.coderslab.dto.BookDto;
import pl.coderslab.dto.CategoryDTO;
import pl.coderslab.dto.PublisherDto;

@Controller
@RequestMapping("/day4")
public class BookRepositoryController {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public BookRepositoryController(BookService bookService, CategoryService categoryService,
	    AuthorService authorService,PublisherService publisherService) {
	this.bookService = bookService;
	this.categoryService = categoryService;
	this.authorService = authorService;
	this.publisherService = publisherService;
    }

    @RequestMapping(path = "/getNumberOfBooks", method = RequestMethod.GET)
    @ResponseBody
    public String getBookQuantity() {

	return "Liczba książek to: " + bookService.getBookCount();

    }

    @RequestMapping(path = "/getBooksByTitle/{title}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<BookDto> findBooksByTitle(@PathVariable("title") String title) {
	return bookService.findBooksByTitle(title);
    }

    @RequestMapping(path = "/getBooksByCategory/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<BookDto> findBooksByCategory(@PathVariable("id") Long id) {

	return bookService.findBooksByCategory(categoryService.find(id));
    }

    @RequestMapping(path = "/getBooksByCategoryId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<BookDto> findBooksByCategoryId(@PathVariable("id") Long id) {

	return bookService.findBooksByCategoryID(id);
    }

    @RequestMapping(path="/getBooksByAuthor/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Collection<BookDto> findBooksByAuthorId(@PathVariable("id") Long id) {
	return bookService.findBooksByAuthorId(id);
    }
    
    @RequestMapping(path="/getBooksByAuthor", method=RequestMethod.GET)
    @ResponseBody
    public Collection<BookDto> findBooksByAuthor() {
	return bookService.findBooksByAuthors(authorService.find(3L));
    }

    @RequestMapping(path="/getBooksByPublisher", method=RequestMethod.GET)
    @ResponseBody
    public Collection<BookDto> findBooksByPublisher() {
	PublisherDto dto = publisherService.find(1L);
	return bookService.findBooksByPublisher(dto);
    }
    
    
    @RequestMapping(path="/getBooksByRating/{rating}", method=RequestMethod.GET)
    @ResponseBody
    public Collection<BookDto> findBooksByRating(@PathVariable("rating")Integer rating){
	return bookService.findBooksByRating(rating);
    }
    @RequestMapping(path="/getFirstBookByCategory", method=RequestMethod.GET)
    @ResponseBody
    public BookDto findFirstBookByCategoryOrderByTitleAsc() {
	CategoryDTO dto = categoryService.find(3L);
	
	return bookService.findFirstBookByCategoryOrderByTitleAsc(dto);
    }
    
}


