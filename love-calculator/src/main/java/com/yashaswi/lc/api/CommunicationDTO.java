package com.yashaswi.lc.api;

import com.yashaswi.lc.validators.PhoneNumber;

public class CommunicationDTO {
	private String mail;
	
	@PhoneNumber
	private Phone phone;
	
	//getters and setters
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	
}
