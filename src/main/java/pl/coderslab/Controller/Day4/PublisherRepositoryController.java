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
import pl.coderslab.dto.AuthorDto;

@Controller
@RequestMapping("/day4")
public class PublisherRepositoryController {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public PublisherRepositoryController(BookService bookService, CategoryService categoryService,
	    AuthorService authorService, PublisherService publisherService) {
	this.bookService = bookService;
	this.categoryService = categoryService;
	this.authorService = authorService;
	this.publisherService = publisherService;
    }

    @RequestMapping(path = "/findAuthorByEmail/{email}/**", method = RequestMethod.GET)
    @ResponseBody
    public AuthorDto findByEmail(@PathVariable("email") String email) {
	return authorService.findByEmail(email);
    }

    @RequestMapping(path = "/findAuthorByPesel/{pesel}", method = RequestMethod.GET)
    @ResponseBody
    public AuthorDto findByPesel(@PathVariable("pesel") String pesel) {
	return authorService.findByPesel(pesel);
    }

    @RequestMapping(path = "/findAuthorsByPLastName/{lastName}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<AuthorDto> findAuthorsByLastName(@PathVariable("lastName") String lastName) {
	return authorService.findByLastName(lastName);
    }
}
