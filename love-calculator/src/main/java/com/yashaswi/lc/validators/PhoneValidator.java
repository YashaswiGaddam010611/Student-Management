package com.yashaswi.lc.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.yashaswi.lc.api.Phone;

public class PhoneValidator implements ConstraintValidator<PhoneNumber,Phone> {
	
	public void initialize(PhoneNumber constraintAnnotation) {
	}

	public boolean isValid(Phone phone, ConstraintValidatorContext context) {
		String cuntryCode = phone.getCountryCode();
		String number = phone.getNumber();
		boolean isAllDigits;
		
		if(number == null)
			return false;
		
		if(number.length() !=  10)
			return false;
		
		isAllDigits = isAllDigits(cuntryCode, number);
		
		if(!isAllDigits)
			return false;
		
		return true;
	}
	
	public boolean isAllDigits(String cuntryCode, String number) {
		boolean isAllDigits = true;
		
		for(int i=0; i<cuntryCode.length(); i++)
			if(!Character.isDigit(cuntryCode.charAt(i)))
				isAllDigits = false;
		
		for(int i=0; i<number.length(); i++)
			if(!Character.isDigit(number.charAt(i)))
				isAllDigits = false;
		
		return isAllDigits;
		
	}
	
}
