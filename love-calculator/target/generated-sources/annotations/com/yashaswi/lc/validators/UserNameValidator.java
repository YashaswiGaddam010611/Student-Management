package com.yashaswi.lc.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.yashaswi.lc.api.RegistrationDTO;

public class UserNameValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return ((RegistrationDTO.class).equals(clazz));
	}

	public void validate(Object target, Errors errors) {
		String userName = ((RegistrationDTO)target).getUserName();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "registration.username.empty", "*UserName cannot be empty");
		
		if((!userName.contains("_")) && (!userName.isEmpty())) {
			errors.rejectValue("userName", "registration.username.invalid", "*UserName must contain underScore i,e. '_'");
		}

	}

}
