package pl.coderslab.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import pl.coderslab.dto.BookDto;

@Entity
@Table(name = "books")
public class Book {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private String title;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Author> authors = new HashSet<>();
	
	private Integer rating;
	
	@ManyToOne// usuniętą CascadeType.Merge - uniknięcię błędu .IllegalStateException: Multiple representations of the same entity 
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	
	private String description;
	
	
	public Book() {
	}

	

	public Long getId() {
		return id;
	}



	public String getTitle() {
		return title;
	}



	public Set<Author> getAuthors() {
		return authors;
	}



	public Integer getRating() {
		return rating;
	}



	public Publisher getPublisher() {
		return publisher;
	}



	public String getDescription() {
		return description;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
	}



	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Transient
	public BookDto toDto() {
		BookDto dto = new BookDto();
		if (Objects.nonNull(getAuthors())&& !getAuthors().isEmpty()) {
			dto.setAuthors(getAuthors().stream().map(Author::toSimpleDto).collect(Collectors.toSet()));
		}
		dto.setDescription(getDescription());
		dto.setId(getId());
		if (Objects.nonNull(getPublisher())) {
			dto.setPublisherDto(getPublisher().toSimpleDto());
		}
		dto.setRating(getRating());
		dto.setTitle(getTitle());
		
		return dto;
	}
	

}
