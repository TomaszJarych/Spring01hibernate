package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import pl.coderslab.dto.PersonDetailDto;

@Entity
@Table(name="personDetail")
public class PersonDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String street;
	private int streetNumber;
	private String city;
	
	
	public PersonDetail(Long id, String firstName, String lastName,
			String street, int streetNumber, String city) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
	}
	
	public PersonDetail(PersonDetailDto dto) {
		this.id = dto.getId();
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.street = dto.getStreet();
		this.streetNumber = dto.getStreetNumber();
		this.city = dto.getCity();
	}
	


	public PersonDetail() {
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


	public String getStreet() {
		return street;
	}


	public int getStreetNumber() {
		return streetNumber;
	}


	public String getCity() {
		return city;
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


	public void setStreet(String street) {
		this.street = street;
	}


	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	@Transient
	public PersonDetailDto toDto() {
		PersonDetailDto dto = new PersonDetailDto();
		dto.setId(getId());
		dto.setFirstName(getFirstName());
		dto.setLastName(getLastName());
		dto.setStreet(getStreet());
		dto.setStreetNumber(getStreetNumber());
		dto.setCity(getCity());
		
		return dto;
		
	}
	
	
}
