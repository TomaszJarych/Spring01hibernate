package pl.coderslab.dto;

public class BookDto {

	private Long id;
	private String title;
	private String author;
	private Integer rating;
	private PublisherDto publisherDto;
	
	private String description;
	public BookDto(Long id, String title, String author, Integer rating,
			PublisherDto publisherDto, String description) {
		this.id = id;
		this.title = title;
		this.author = author;
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

	public String getAuthor() {
		return author;
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

	public void setAuthor(String author) {
		this.author = author;
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

	@Override
	public String toString() {
		return "BookDto [id=" + id + ", title=" + title + ", author=" + author
				+ ", rating=" + rating + ", publisherDto=" + publisherDto
				+ ", description=" + description + "]";
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