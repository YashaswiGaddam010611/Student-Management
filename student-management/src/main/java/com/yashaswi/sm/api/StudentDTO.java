package com.yashaswi.sm.api;

public class StudentDTO {
	private int id;
	private String studentName;
	private Long mobileNumber;
	private String country;
	
	
	//getters and setters
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [studentName=" + studentName + ", mobileNumber=" + mobileNumber + ", country=" + country
				+ "]";
	}
	
}
