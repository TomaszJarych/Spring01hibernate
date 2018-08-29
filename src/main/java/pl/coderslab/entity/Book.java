package pl.coderslab.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import pl.coderslab.DAO.PublisherDao;
import pl.coderslab.dto.BookDto;
import pl.coderslab.dto.PublisherDto;

@Entity
@Table(name = "books")
public class Book {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private String title;
	
	private String author;
	
	private Integer rating;
	
	@ManyToOne(cascade= {CascadeType.MERGE})
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	
	private String description;
	
	
	
	public Book() {
	}
	
	public Book(Long id, String title, String author, Integer rating,
			Publisher publisher, String description) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.rating = rating;
		this.publisher = publisher;
		this.description = description;
	}
	

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
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

	public void setAuthor(String author) {
		this.author = author;
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
	
	

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author
				+ ", rating=" + rating + ", description=" + description + "]";
	}

	@Transient
	public BookDto toDto() {
		BookDto dto = new BookDto();
		dto.setAuthor(getAuthor());
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
