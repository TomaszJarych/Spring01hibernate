package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.Service.AuthorService;
import pl.coderslab.dto.AuthorDto;

public class AuthorConverter implements Converter<String, AuthorDto>{
	
	@Autowired
	private AuthorService service;


	@Override
	public AuthorDto convert(String source) {
		return service.find(Long.valueOf(source));
	}

}
