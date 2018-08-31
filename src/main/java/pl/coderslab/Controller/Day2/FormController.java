package pl.coderslab.Controller.Day2;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.AuthorService;
import pl.coderslab.Service.BookService;
import pl.coderslab.Service.PersonService;
import pl.coderslab.Service.PublisherService;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.dto.BookDto;
import pl.coderslab.dto.PersonDetailDTODay2;
import pl.coderslab.dto.PersonDto;
import pl.coderslab.dto.PublisherDto;

@Controller
@RequestMapping("/day2")
public class FormController {

	private final PersonService service;
	private final BookService bookService;
	private final PublisherService publisherService;
	private final AuthorService authorService;

	@Autowired
	public FormController(PersonService service, BookService bookService,
			PublisherService publisherService, AuthorService authorService) {
		this.service = service;
		this.bookService = bookService;
		this.publisherService = publisherService;
		this.authorService = authorService;
	}

	@RequestMapping(path = "/personSimpleForm", method = RequestMethod.GET)
	public String personForm(Model model) {

		model.addAttribute("person", new PersonDto());

		return "personForm";
	}

	@RequestMapping(path = "/personSimpleFormProcess", method = RequestMethod.POST)
	@ResponseBody
	public PersonDto processForm(
			@ModelAttribute(name = "person") PersonDto dto) {
		service.save(dto);

		return dto;
	}

	@RequestMapping(path = "/personDetailForm", method = RequestMethod.GET)
	public String getDetailedFomr(Model model) {

		model.addAttribute("personDetail", new PersonDetailDTODay2());

		return "personDetailForm";
	}

	@RequestMapping(path = "/personDetailForm", method = RequestMethod.POST)
	@ResponseBody
	public PersonDetailDTODay2 processForm(
			@ModelAttribute("personDetail") PersonDetailDTODay2 dto) {

		return dto;
	}

	@ModelAttribute("countries")
	private Collection<String> getCountries() {
		return Arrays.asList("Poland", "Germany", "Russia", "United Kingdom",
				"USA", "Canada");
	}

	@ModelAttribute("skills")
	private Collection<String> getSkills() {
		return Arrays.asList("PHP", "Java", "JavaScript", "BrainFuck", "OOP",
				"C++", "C#");
	}

	@ModelAttribute("hobbies")
	private Collection<String> getHobbies() {
		return Arrays.asList("Programming", "Running marathons", "Basketball",
				"Reading mysteries books");
	}

	// Zadania z działu Formularze-Encje

	@RequestMapping(path = "/addBookForm", method = RequestMethod.GET)
	public String addBookForm(Model model) {
		model.addAttribute("book", new BookDto());

		return "bookForm";

	}

	@RequestMapping(path = "/processBookForm", method = RequestMethod.POST)
	@ResponseBody
	public BookDto processAddBookForm(@ModelAttribute("book") BookDto dto) {
		return bookService.save(dto);
	}

	@RequestMapping(path = "/books", method = RequestMethod.GET)
	public String getAllBooks(Model model) {

		model.addAttribute("books", bookService.getAll());

		return "allBooks";
	}

	@RequestMapping(path = "/getBook/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.find(id));

		return "bookForm";
	}

	@RequestMapping(path = "/getBook/**", method = RequestMethod.POST)
	public String processEditBook(@ModelAttribute("book") BookDto dto) {

		bookService.update(dto);

		return "redirect:/day2/books";
	}

	@RequestMapping(path = "/confirmDelete/{id}", method = RequestMethod.GET)
	public String confirmDeleteBook(@PathVariable("id") Long id, Model model) {

		model.addAttribute("book", bookService.find(id));

		return "confirmDeletePage";
	}

	@RequestMapping(path = "/deleteBook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id) {

		bookService.remove(id);

		return "redirect:/day2/books";
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

	// Zadanie 5 - Author

	@RequestMapping(path = "/authors", method = RequestMethod.GET)
	public String showAuthorsList() {

		return "authorsList";
	}

	@RequestMapping(path = "/addAuthor", method = RequestMethod.GET)
	public String showAddAuthorForm(Model model) {

		model.addAttribute("author", new AuthorDto());

		return "authorForm";
	}

	@RequestMapping(path = "/processAuthorForm", method = RequestMethod.POST)
	public String processAuthorForm(@ModelAttribute("author") AuthorDto dto) {

		authorService.save(dto);

		return "redirect:authors";
	}

	@RequestMapping(path = "/editAuthor/{id}", method = RequestMethod.GET)
	public String editAuthor(@PathVariable("id")Long id, Model model) {

		model.addAttribute("author", authorService.find(id));

		return "authorForm";
	}
	
	@RequestMapping(path = "/editAuthor/**", method = RequestMethod.POST)
	public String processAuthorEditForm(@ModelAttribute("author") AuthorDto dto, Model model) {

		authorService.update(dto);

		return "redirect:/day2/authors";
	}
	
	@RequestMapping(path = "/deleteAuthor/{id}", method = RequestMethod.GET)
	public String deleteAuthor(@PathVariable("id")Long id) {
		
		authorService.remove(id);
		
		return "redirect:/day2/authors";

	}
	
	// Zadanie 6 - Publisher

}
