package pl.coderslab.Controller.Day3;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.AuthorService;
import pl.coderslab.Service.BookService;
import pl.coderslab.Service.PublisherService;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.dto.BookDto;
import pl.coderslab.dto.PublisherDto;

@Controller
@RequestMapping("/day3/validate")
public class ValidationController {

    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final BookService bookService;
    private final Validator validator;

    @Autowired
    public ValidationController(AuthorService authorService, PublisherService publisherService, BookService bookService,
	    Validator validator) {
	this.authorService = authorService;
	this.publisherService = publisherService;
	this.bookService = bookService;
	this.validator = validator;
    }

    @RequestMapping(path = "/bookOk", method = RequestMethod.GET)
    @ResponseBody
    public String validateBookOk() {
	BookDto dto = new BookDto();
	dto.setId(12L);
	dto.setPages(1223);
	dto.setRating(6);
	dto.setTitle("Java Core");
	AuthorDto authorDto = new AuthorDto("Janusz", "Marciniak", "80072909146", "email@wp.pl");
	dto.getAuthors().add(authorDto);
	PublisherDto publisherDto = new PublisherDto(10L, "Albatros");
	dto.setPublisherDto(publisherDto);
	dto.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur nec accumsan mi. "
		+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
		+ "Ut malesuada quam nec lectus facilisis fermentum. "
		+ "Donec eleifend augue vel ante euismod, nec pharetra leo scelerisque. "
		+ "Aenean vel metus lobortis, mollis metus quis, egestas libero. ");

	Set<ConstraintViolation<BookDto>> validate = validator.validate(dto);

	if (!validate.isEmpty()) {
	    return validate.stream().map(el -> el.getPropertyPath() + " " + el.getMessage())
		    .collect(Collectors.joining(":\n"));
	}

	return "wszystko ok" + dto;
    }

    @RequestMapping(path = "/bookNotOk", method = RequestMethod.GET)
    public String validateBookNotOk(Model model) {
	BookDto dto = new BookDto();
	dto.setId(12L);
	dto.setPages(0);
	dto.setRating(11);
	dto.setTitle("");
	AuthorDto authorDto = new AuthorDto("Janusz", "Marciniak", "80072909146", "email@wp.pl");
	dto.getAuthors().add(null);
	PublisherDto publisherDto = new PublisherDto(10L, "Albatros");
	dto.setPublisherDto(null);
	dto.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur nec accumsan mi. "
		+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
		+ "Ut malesuada quam nec lectus facilisis fermentum. "
		+ "Donec eleifend augue vel ante euismod, nec pharetra leo scelerisque. "
		+ "Aenean vel metus lobortis, mollis metus quis, egestas libero. "
		+ "Nam aliquet sagittis urna et viverra. " + "Ut vitae luctus metus, ut posuere leo. "
		+ "Aliquam efficitur risus erat, congue tincidunt sem feugiat et. "
		+ "Donec at consequat nisl. Curabitur mattis nibh quis metus imperdiet, et laoreet est vehicula. "
		+ "Vivamus id est commodo, dapibus lorem sed, mollis lacus. Nam non pretium nibh. "
		+ "Sed eget ligula non ex elementum consequat ut vitae velit. "
		+ "In hac habitasse platea dictumst. Donec tincidunt dui enim, a dictum odio iaculis id. "
		+ "Etiam egestas quam lectus, venenatis vulputate neque suscipit et.");

	Set<ConstraintViolation<BookDto>> validate = validator.validate(dto);
	if (!validate.isEmpty()) {

	    model.addAttribute("errors", validate.stream().map(el -> el.getPropertyPath() + " : " + el.getMessage())
		    .collect(Collectors.toSet()));
	    return "errors";
	} else {
	    model.addAttribute("errors", null);
	    return "errors";
	}
    }

    @RequestMapping(path = "/authorOk", method = RequestMethod.GET)
    @ResponseBody
    public String validateAuthorOk() {
	AuthorDto dto = new AuthorDto("Janusz", "Marciniak", "80072909146", "email@wp.pl");

	Set<ConstraintViolation<AuthorDto>> validate = validator.validate(dto);

	if (!validate.isEmpty()) {
	    return validate.stream().map(el -> el.getPropertyPath() + " " + el.getMessage())
		    .collect(Collectors.joining(":\n"));
	}

	return "wszystko ok " + dto;
    }

    @RequestMapping(path = "/authorNotOk", method = RequestMethod.GET)
    public String validateAuthorNotOk(Model model) {
	AuthorDto dto = new AuthorDto("", "", "80072912109146", "email@@wp.pl");

	Set<ConstraintViolation<AuthorDto>> validate = validator.validate(dto);

	if (!validate.isEmpty()) {
	    model.addAttribute("errors", validate.stream().map(el -> el.getPropertyPath() + " " + el.getMessage())
		    .collect(Collectors.toList()));

	    return "errors";

	} else {
	    model.addAttribute("errors", null);
	    return "errors";
	}
    }

    @RequestMapping(path = "/publisherOk", method = RequestMethod.GET)
    @ResponseBody
    public String validatePublisherOk() {
	
	PublisherDto dto = new PublisherDto("Albatros", "8451769793", "732065814");
	
	Set<ConstraintViolation<PublisherDto>> validate = validator.validate(dto);

	if (!validate.isEmpty()) {
	    return validate.stream().map(el -> el.getPropertyPath() + " " + el.getMessage())
		    .collect(Collectors.joining(":\n"));
	}

	return "wszystko ok " + dto;
    }

    @RequestMapping(path = "/publisherNotOk", method = RequestMethod.GET)
    public String validatePublisherNotOk(Model model) {
	
	PublisherDto dto = new PublisherDto("", "8451764439793", "7320658343434343414");

	Set<ConstraintViolation<PublisherDto>> validate = validator.validate(dto);

	if (!validate.isEmpty()) {
	    model.addAttribute("errors", validate.stream().map(el -> el.getPropertyPath() + " " + el.getMessage())
		    .collect(Collectors.toList()));

	    return "errors";

	} else {
	    model.addAttribute("errors", null);
	    return "errors";
	}
    }

    // @ModelAttribute("publishers")
    // private Collection<PublisherDto> getpublishers() {
    // return publisherService.getAll();
    // }
    //
    // @ModelAttribute("authors")
    // private Collection<AuthorDto> getAuthors() {
    // return authorService.getAll();
    // }
}
