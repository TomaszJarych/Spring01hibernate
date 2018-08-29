package pl.coderslab.dto;

public class PublisherDto {
	
	private Long id;

	private String name;

	
	
	public PublisherDto() {
	}

	public PublisherDto(Long id, String name) {
		this.id = id;
		this.name = name;
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
		return "PublisherDto [id=" + id + ", name=" + name + "]";
	}

	
	
}
