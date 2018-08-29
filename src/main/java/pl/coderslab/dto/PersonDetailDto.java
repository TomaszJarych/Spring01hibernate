package pl.coderslab.dto;

public class PersonDetailDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String street;
	private int streetNumber;
	private String city;
	
	
	public PersonDetailDto(String firstName, String lastName, String street,
			int streetNumber, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
	}
	public PersonDetailDto() {
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getStreet() {
		return street;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public String getCity() {
		return city;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "PersonDetailDto [firstName=" + firstName + ", lastName="
				+ lastName + ", street=" + street + ", streetNumber="
				+ streetNumber + ", city=" + city + "]";
	}

}
