package pl.coderslab.Controller.Day3;

import java.util.Collection;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.Service.AuthorService;
import pl.coderslab.Service.BookService;
import pl.coderslab.Service.PublisherService;
import pl.coderslab.Validator.ValidationGroups.IsProposition;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.dto.BookDto;
import pl.coderslab.dto.PublisherDto;

@Controller
@RequestMapping("/day3/proposition")
public class PropositionController {
    
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final BookService bookService;
    private final Validator validator;
    
    @Autowired
    public PropositionController(AuthorService authorService, PublisherService publisherService,
	    BookService bookService, Validator validator) {
	this.authorService = authorService;
	this.publisherService = publisherService;
	this.bookService = bookService;
	this.validator = validator;
    }
    
    @RequestMapping(path = "/addBookForm", method = RequestMethod.GET)
    public String addBookForm(Model model) {
	model.addAttribute("book", new BookDto());

	return "propositionBookForm";

    }

    @RequestMapping(path = "/processBookForm", method = RequestMethod.POST)
    public String processAddBookForm(@Validated({IsProposition.class}) @ModelAttribute("book") BookDto dto, BindingResult result, Model model) {
	if (result.hasErrors()) {
	    model.addAttribute("book", dto);

	    return "propositionBookForm";

	} else {
	    bookService.save(dto);
	    return "redirect:/day3/proposition/books";
	}

    }

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public String getAllBooks(Model model) {

	model.addAttribute("books", bookService.getAllPropositions());

	return "allBooks";
    }

    @RequestMapping(path = "/getBook/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model) {
	model.addAttribute("book", bookService.find(id));

	return "propositionBookForm";
    }

    @RequestMapping(path = "/getBook/**", method = RequestMethod.POST)
    public String processEditBook(@Validated({IsProposition.class}) @ModelAttribute("book") BookDto dto, BindingResult result, 
	    Model model) {
	if (result.hasErrors()) {
	    model.addAttribute("book", dto);
	    return "propositionBookForm";

	} else {
	    bookService.update(dto);
	    return "redirect:/day3/proposition/books";
	}
    }

    @RequestMapping(path = "/confirmDelete/{id}", method = RequestMethod.GET)
    public String confirmDeleteBook(@PathVariable("id") Long id, Model model) {

	model.addAttribute("book", bookService.find(id));

	return "confirmDeletePage";
    }

    @RequestMapping(path = "/deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id) {

	bookService.remove(id);

	return "redirect:/day3/proposition/books";
    }

    // ModelAttributes

    @ModelAttribute("publishers")
    private Collection<PublisherDto> getpublishers() {
	return publisherService.getAll();
    }

    @ModelAttribute("authors")
    private Collection<AuthorDto> getAuthors() {
	return authorService.getAll();
    }


    
}
