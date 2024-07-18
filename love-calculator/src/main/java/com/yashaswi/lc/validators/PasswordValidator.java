package com.yashaswi.lc.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, char[]> {
	private int length;
	public void initialize(Password password) {
		this.length = password.length();
	}

	public boolean isValid(char[] value, ConstraintValidatorContext context) {
		System.out.println("inside the isValid method of PasswordValidator");
		
		if(value.length < length)
			return false;
		
		return true;
	}

}
