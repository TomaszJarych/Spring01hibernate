package pl.coderslab.dto;

import java.util.HashSet;
import java.util.Set;


public class PublisherDto {
	
	private Long id;

	private String name;
	
	private Set<BookDto> books = new HashSet<>();

	
	
	public PublisherDto() {
	}

	public PublisherDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BookDto> getBooks() {
		return books;
	}

	public void setBooks(Set<BookDto> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "PublisherDto [id=" + id + ", name=" + name + "]";
	}

	
	
}
