package pl.coderslab.Controller.Day4;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.AuthorService;
import pl.coderslab.Service.BookService;
import pl.coderslab.Service.CategoryService;
import pl.coderslab.Service.PublisherService;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.dto.PublisherDto;

@Controller
@RequestMapping("/day4")
public class AuthorRepositoryController {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public AuthorRepositoryController(BookService bookService, CategoryService categoryService,
	    AuthorService authorService, PublisherService publisherService) {
	this.bookService = bookService;
	this.categoryService = categoryService;
	this.authorService = authorService;
	this.publisherService = publisherService;
    }

    @RequestMapping(path = "/getPublisherByNip/{nip}")
    @ResponseBody
    public PublisherDto findByNip(@PathVariable("nip") String nip) {
	return publisherService.findByNip(nip);
    }
    
    @RequestMapping(path = "/getPublisherByRegon/{regon}")
    @ResponseBody
    public PublisherDto findByRegon(@PathVariable("regon") String regon) {
	return publisherService.findByRegon(regon);
    }
    
    @RequestMapping(path = "/getAuthorByEmailQuery/{beginning}")
    @ResponseBody
    public Collection<AuthorDto> findByEmailBeginningQuery(@PathVariable("beginning") String beginning) {
	return authorService.findByEmailBeginningQuery(beginning);
    }
    @RequestMapping(path = "/findByPeselBeginningWithQuery/{beginning}")
    @ResponseBody
    public Collection<AuthorDto> findByPeselBeginningWithQuery(@PathVariable("beginning") String beginning) {
	return authorService.findByPeselBeginningWithQuery(beginning);
    }
}
