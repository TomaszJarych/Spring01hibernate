package pl.coderslab.dto;

import pl.coderslab.entity.PersonDetail;

public class PersonDto {
	
	private Long id;
	private String login;
	private String password;
	private String email;
	private PersonDetailDto detail;
	
	public PersonDto(Long id, String login, String password, String email,
			PersonDetailDto detail) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.detail = detail;
	}

	public PersonDto() {
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

	public PersonDetailDto getDetail() {
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

	public void setDetail(PersonDetailDto detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "PersonDto [id=" + id + ", login=" + login + ", password="
				+ password + ", email=" + email + ", detail=" + detail + "]";
	}
	
	
	
	

}
