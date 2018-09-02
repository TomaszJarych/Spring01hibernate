package pl.coderslab.dto;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

public class PublisherDto {

    private Long id;

    @NotBlank
    private String name;
    
    @NIP
    private String nip;
    
    @REGON
    private String regon;

    private Set<BookDto> books = new HashSet<>();

    public PublisherDto() {
    }

    public PublisherDto(Long id, String name) {
	this.id = id;
	this.name = name;
    }

    public PublisherDto(String name, String nip, String regon) {
	this.name = name;
	this.nip = nip;
	this.regon = regon;
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

    @Override
    public String toString() {
	return "PublisherDto [id=" + id + ", name=" + name + ", nip=" + nip + ", regon=" + regon + ", books=" + books
		+ "]";
    }

}
