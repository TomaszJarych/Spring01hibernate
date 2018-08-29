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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import pl.coderslab.dto.AuthorDto;
import pl.coderslab.dto.BookDto;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER, cascade = {
			CascadeType.ALL})
	private Set<Book> books = new HashSet<>();

	public Author(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author() {
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

	@Transient
	public AuthorDto toDto() {

		AuthorDto dto = new AuthorDto();
		dto.setId(getId());
		dto.setFirstName(getFirstName());
		dto.setLastName(getLastName());
		if (Objects.nonNull(getBooks()) && !getBooks().isEmpty()) {
			dto.setBooks(getBooks()
					.stream()
					.map(Book::toDto)
					.collect(Collectors.toSet()));
		}

		return dto;
	}

	@Transient
	public AuthorDto toSimpleDto() {

		AuthorDto dto = new AuthorDto();

		dto.setId(getId());
		dto.setFirstName(getFirstName());
		dto.setLastName(getLastName());
		return dto;
	}

}
