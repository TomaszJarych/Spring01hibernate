package pl.coderslab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private String author;
	
	private Integer rating;
	
	private String publisher;
	
	private String description;
	
	public Book(String title, String author, Integer rating, String publisher,
			String description) {
		this.title = title;
		this.author = author;
		this.rating = rating;
		this.publisher = publisher;
		this.description = description;
	}
	public Book() {
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
	public String getPublisher() {
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
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author
				+ ", rating=" + rating + ", publisher=" + publisher
				+ ", description=" + description + "]";
	}
	@Transient
	public BookDto toDto() {
		BookDto dto = new BookDto();
		dto.setAuthor(getAuthor());
		dto.setDescription(getDescription());
		dto.setId(getId());
		dto.setPublisher(getPublisher());
		dto.setRating(getRating());
		dto.setTitle(getTitle());
		
		return dto;
	}
	

}
