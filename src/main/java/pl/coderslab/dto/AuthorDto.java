package pl.coderslab.dto;

public class AuthorDto {

	private Long id;
	private String firstName;
	private String lastName;

	public AuthorDto(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	@Override
	public String toString() {
		return "AuthorDto [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
