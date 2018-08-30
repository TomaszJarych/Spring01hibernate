package pl.coderslab.dto;

import java.util.Arrays;

public class PersonDetailDTODay2 {

	private String login;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private String country;
	private String notes;
	private boolean mailingList;
	private String[] programmingSkills;
	private String[] hobbies;

	public PersonDetailDTODay2(String login, String password, String email,
			String firstName, String lastName, String gender, String country,
			String notes, boolean mailingList, String[] programmingSkills,
			String[] hobbies) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.notes = notes;
		this.mailingList = mailingList;
		this.programmingSkills = programmingSkills;
		this.hobbies = hobbies;
	}

	public PersonDetailDTODay2() {
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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public String getNotes() {
		return notes;
	}

	public boolean isMailingList() {
		return mailingList;
	}

	public String[] getProgrammingSkills() {
		return programmingSkills;
	}

	public String[] getHobbies() {
		return hobbies;
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setMailingList(boolean mailingList) {
		this.mailingList = mailingList;
	}

	public void setProgrammingSkills(String[] programmingSkills) {
		this.programmingSkills = programmingSkills;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "PersonDetailDTODay2 [login=" + login + ", password=" + password
				+ ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", country="
				+ country + ", notes=" + notes + ", mailingList=" + mailingList
				+ ", programmingSkills=" + Arrays.toString(programmingSkills)
				+ ", hobbies=" + Arrays.toString(hobbies) + "]";
	}

}
