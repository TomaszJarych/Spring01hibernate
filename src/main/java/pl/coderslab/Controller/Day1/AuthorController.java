package pl.coderslab.Controller.Day1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.AuthorService;
import pl.coderslab.dto.AuthorDto;

@Controller
@RequestMapping("/day1")
public class AuthorController {

	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping(path = "/addAuthor", method = RequestMethod.POST)
	@ResponseBody
	public String addAuthor() {
		AuthorDto dto1 = new AuthorDto("Jan", "Kowalski");
		AuthorDto dto2 = new AuthorDto("Adam", "Nowak");
		AuthorDto dto3 = new AuthorDto("Marcin", "Wójcik");
		authorService.save(dto1);
		authorService.save(dto2);
		authorService.save(dto3);
		return "Authors has been added";
	}

	@RequestMapping(path = "/getAuthor/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AuthorDto findAuthorById(@PathVariable("id") Long id) {
		return authorService.find(id);
	}
	@RequestMapping(path = "/updateAuthor/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public AuthorDto updateAuthor(@PathVariable("id") Long id) {
		AuthorDto dto = authorService.find(id);
		dto.setFirstName("Andrzej");
		dto.setLastName("Łazarewicz");

		authorService.update(dto);

		return dto;
	}

	@RequestMapping(path = "/deleteAuthor/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteAuthor(@PathVariable("id") Long id) {

		try {
			authorService.remove(id);
		} catch (Exception e) {
			return "Pointed author doesn't exist";
		}
		return "The author has been removed";
	}

	@RequestMapping(path = "/getAllAuthors", method = RequestMethod.GET)
	@ResponseBody
	public Collection<AuthorDto> getAllAuthors() {
		return authorService.getAll();
	}

}
