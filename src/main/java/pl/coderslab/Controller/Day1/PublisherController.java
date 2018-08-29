package pl.coderslab.Controller.Day1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.PublisherService;
import pl.coderslab.dto.PublisherDto;

@Controller
@RequestMapping("/day1")
public class PublisherController {

	private final PublisherService publisherService;

	@Autowired
	public PublisherController(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	@RequestMapping(path = "/addPublisher", method = RequestMethod.POST)
	@ResponseBody
	public String addPublisher() {
		return "Publisher has been added";

	}

	@RequestMapping(path = "/getPublisher/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PublisherDto getPublisher(@PathVariable("id") Long id) {
		return publisherService.find(id);

	}

	@RequestMapping(path = "/updatePublisher/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public PublisherDto updatePublisher(@PathVariable("id") Long id) {
		PublisherDto dto = publisherService.find(id);
		return dto;
	}

	@RequestMapping(path = "/deletePublisher/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deletePublisher(@PathVariable("id") Long id) {
		publisherService.remove(id);
		
		return "Publisher has been deleted";
	}
	
	@RequestMapping(path = "/getAllPublishers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<PublisherDto> getAllPublishers(){
		
		return publisherService.getAll();
	}

}
