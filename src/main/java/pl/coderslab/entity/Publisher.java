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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import pl.coderslab.dto.PublisherDto;

@Entity
@Table(name = "publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy="publisher", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	private Set<Book> books = new HashSet<>();

	public Publisher(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Publisher() {
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

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + "]";
	}
	

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Transient
	public PublisherDto toDto() {
		PublisherDto dto = new PublisherDto();
		dto.setId(getId());
		dto.setName(getName());
		if (Objects.nonNull(getBooks())&& !getBooks().isEmpty()) {
        	dto.setBooks(getBooks().stream().map(Book::toDto).collect(Collectors.toSet()));
		}

		return dto;
	}
	
	@Transient
    public PublisherDto toSimpleDto() {
        PublisherDto dto = new PublisherDto();
        dto.setId(getId());
        dto.setName(getName());
        return dto;
    }
	
	

}
