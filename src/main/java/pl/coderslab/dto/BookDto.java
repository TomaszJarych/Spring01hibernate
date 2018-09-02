package pl.coderslab.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import pl.coderslab.Validator.ValidationGroups.IsProposition;

public class BookDto {

    private Long id;

    @NotBlank(groups = { Default.class, IsProposition.class })
    @Size(min = 5,groups = { Default.class,IsProposition.class })
    private String title;
    
    
    @NotNull(groups = { Default.class })
    private Set<AuthorDto> authors = new HashSet<>();

    @NotNull(groups = { Default.class })
    @Min(value=1,groups = { Default.class })
    @Max(value=10,groups = { Default.class })
    private Integer rating;

    @NotNull(groups = { Default.class })
    private PublisherDto publisherDto;

    @Size(max = 600, groups = { Default.class, IsProposition.class })
    private String description;

    @NotNull(groups = { Default.class })
    @Min(value = 1, groups = { Default.class })
    private Integer pages;
    
    @AssertTrue(groups= {IsProposition.class})
    @AssertFalse(groups = { Default.class })
    private boolean proposition;

    public BookDto(Long id, String title, Set<AuthorDto> authors, Integer rating, PublisherDto publisherDto,
	    String description) {
	this.id = id;
	this.title = title;
	this.authors = authors;
	this.rating = rating;
	this.publisherDto = publisherDto;
	this.description = description;
    }

    public BookDto() {
    }

    public Long getId() {
	return id;
    }

    public String getTitle() {
	return title;
    }

    public Integer getRating() {
	return rating;
    }

    public PublisherDto getPublisherDto() {
	return publisherDto;
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

    public void setRating(Integer rating) {
	this.rating = rating;
    }

    public void setPublisherDto(PublisherDto publisherDto) {
	this.publisherDto = publisherDto;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Set<AuthorDto> getAuthors() {
	return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
	this.authors = authors;
    }

    public Integer getPages() {
	return pages;
    }

    public void setPages(Integer pages) {
	this.pages = pages;
    }

    public boolean isProposition() {
	return proposition;
    }

    public void setProposition(boolean proposition) {
	this.proposition = proposition;
    }

    @Override
    public String toString() {
	return "BookDto [id=" + id + ", title=" + title + ", authors=" + authors + ", rating=" + rating
		+ ", publisherDto=" + publisherDto + ", description=" + description + ", pages=" + pages + "]";
    }
}
// 1. W projekcie `Spring01hibernate` utwórz encje o nazwie `Book`.
// 2. Ustal nazwę tabeli bazy danych dla tej encji na `books`.
// 3. Encja ma zawierać następujące pola:
// - id
// - title
// - author
// - rating
// - publisher
// - description
// 4. Uruchom aplikację a następnie sprawdź czy w bazie danych pojawiła się
// tabela.
