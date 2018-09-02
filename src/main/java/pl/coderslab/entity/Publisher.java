package pl.coderslab.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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

    private String nip;

    private String regon;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();

    public Publisher(Long id, String name) {
	this.id = id;
	this.name = name;
    }
    
    public Publisher(String name, String nip, String regon) {
	this.name = name;
	this.nip = nip;
	this.regon = regon;
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
    

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public Set<Book> getBooks() {
	return books;
    }

    public void setBooks(Set<Book> books) {
	this.books = books;
    }
    
    @Override
    public String toString() {
	return "Publisher [id=" + id + ", name=" + name + ", nip=" + nip + ", regon=" + regon + ", books=" + books
		+ "]";
    }

    @Transient
    public PublisherDto toDto() {
	PublisherDto dto = new PublisherDto();
	dto.setId(getId());
	dto.setName(getName());
	if (Objects.nonNull(getBooks()) && !getBooks().isEmpty()) {
	    dto.setBooks(getBooks().stream().map(Book::toDto).collect(Collectors.toSet()));
	}
	if (getNip() != null) {
	    dto.setNip(getNip());
	}
	if (getRegon() != null) {
	    dto.setRegon(getRegon());
	}

	return dto;
    }

    @Transient
    public PublisherDto toSimpleDto() {
	PublisherDto dto = new PublisherDto();
	dto.setId(getId());
	dto.setName(getName());
	if (getNip() != null) {
	    dto.setNip(getNip());
	}
	if (getRegon() != null) {
	    dto.setRegon(getRegon());
	}
	
	return dto;
    }

}
