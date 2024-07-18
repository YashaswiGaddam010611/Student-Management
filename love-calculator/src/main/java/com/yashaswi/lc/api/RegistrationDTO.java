package com.yashaswi.lc.api;

import javax.validation.constraints.NotEmpty;

import com.yashaswi.lc.validators.Age;
import com.yashaswi.lc.validators.Password;

public class RegistrationDTO {
	
	@NotEmpty(message="{user.empty.error}")
	private String user;
	private String userName;
	
	@Password(length=8)
	private char[] password;
	private String country;
	private String hobbies[];
	private String gender;
	
	@Age(lower=18, upper=30)
	private Integer age;
	
	private CommunicationDTO communicationDTO;
	
	//getters and setters
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setHobbies(String hobbies[]) {
		this.hobbies = hobbies;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	
	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}
	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	
}
