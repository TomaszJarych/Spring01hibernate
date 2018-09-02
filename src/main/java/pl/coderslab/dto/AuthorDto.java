package pl.coderslab.dto;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;

import pl.coderslab.Validator.IsAdult;

public class AuthorDto {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @PESEL
    private String pesel;

    @Email
    private String email;
    
    @IsAdult
    private Integer yearOfBirth;

    private Set<BookDto> books = new HashSet<>();

    public AuthorDto(String firstName, String lastName, String pesel, String email) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.pesel = pesel;
	this.email = email;
    }

    public AuthorDto() {
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

    public String getFullName() {
	return firstName + " " + lastName;
    }

    public Set<BookDto> getBooks() {
	return books;
    }

    public void setBooks(Set<BookDto> books) {
	this.books = books;
    }

    public String getPesel() {
	return pesel;
    }

    public String getEmail() {
	return email;
    }

    public void setPesel(String pesel) {
	this.pesel = pesel;
    }

    public void setEmail(String email) {
	this.email = email;
    }
    

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
	return "AuthorDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pesel=" + pesel
		+ ", email=" + email + ", books=" + books + "]";
    }

}
