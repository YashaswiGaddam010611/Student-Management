package com.yashaswi.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {
	
	@NotBlank(message="*please enter your name to proceed..")
	@Size(min=3, max=15, message="*your name should contain 3 to 15 characters")
	private String yourName;
	
	@NotBlank(message="*please enter your name to proceed..")
	@Size(min=3, max=15, message="{crushName.error.message}")
	private String crushName;
	
	@AssertTrue(message="agree that all theese for fun..")
	private boolean termAndCondition;
	
	private String result;
	
	public void setYourName(String yourName) {
		this.yourName = yourName;
	}
	public String getYourName() {
		return yourName;
	}
	
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	public String getCrushName() {
		return crushName;
	}
	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
