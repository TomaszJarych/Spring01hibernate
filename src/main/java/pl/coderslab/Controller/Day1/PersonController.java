package pl.coderslab.Controller.Day1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.PersonDetailService;
import pl.coderslab.Service.PersonService;
import pl.coderslab.dto.PersonDetailDto;
import pl.coderslab.dto.PersonDto;

@Controller
@RequestMapping("/day1")
public class PersonController {

	private final PersonService personService;
	private final PersonDetailService personDetailService;
	@Autowired
	public PersonController(PersonService personService,
			PersonDetailService detailService) {
		this.personService = personService;
		this.personDetailService = detailService;
	}

	@RequestMapping(path = "/addPerson", method = RequestMethod.POST)
	@ResponseBody
	public PersonDto addPerson() {
		PersonDto dto = new PersonDto();
		dto.setLogin("jKowal");
		dto.setEmail("jankowal@gmail.com");
		dto.setPassword("admin");
		PersonDetailDto detailDto = new PersonDetailDto("Jan", "Kowalski",
				"Piłsudskiego", 445, "Wrocław");
		dto.setDetail(detailDto);

		personService.save(dto);
		return dto;
	}

	@RequestMapping(path = "/getPerson/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PersonDto getPersonByid(@PathVariable("id") Long id) {

		return personService.find(id);
	}

	@RequestMapping(path = "/updatePerson/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public PersonDto updatePersonByid(@PathVariable("id") Long id) {
		PersonDto dto = personService.find(id);

		dto.setLogin("innyLoign");
		System.out.println(dto);
		
		return personService.update(dto);
	}
	
	@RequestMapping(path = "/deletePerson/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deletePerson(@PathVariable("id") Long id) {
		personService.remove(id);
		
		return "This person has been deleted";
	}
	
	@RequestMapping(path = "/getAllPerson", method = RequestMethod.GET)
	@ResponseBody
	public Collection<PersonDto> getAllPersons(){
		return personService.getAll();
	}
	
	

}
