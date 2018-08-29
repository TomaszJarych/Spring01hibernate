package pl.coderslab.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import pl.coderslab.dto.PersonDto;

@Entity
@Table(name="person")
public class Person {
	
	public Person(Long id, String login, String password, String email,
			PersonDetail detail) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.detail = detail;
	}
	

	public Person() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String login;
	
	private String password;
	
	private String email;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private PersonDetail detail;

	public Person(PersonDto dto) {
		this.id = dto.getId();
		this.login = dto.getLogin();
		this.password = dto.getPassword();
		this.email = dto.getEmail();
		if (Objects.nonNull(dto.getDetail())) {
			PersonDetail detail = new PersonDetail(dto.getDetail());
			this.detail = detail;
			
		}
	}
	
	public Long getId() {
		return id;
	}


	public String getLogin() {
		return login;
	}


	public String getPassword() {
		return password;
	}


	public String getEmail() {
		return email;
	}


	public PersonDetail getDetail() {
		return detail;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setDetail(PersonDetail detail) {
		this.detail = detail;
	}


	@Transient
	public PersonDto toDto() {
		PersonDto dto = new PersonDto(getId(), getLogin(), getPassword(), getEmail(), getDetail().toDto());
		
		return dto;
		
	}
	
	

}
