package com.yashaswi.lc.api;

public class Phone {
	private String countryCode;
	private String number;
	
	//getters and setters
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	//to string
	@Override
	public String toString() {
		return countryCode+"-"+number;
	}
}
