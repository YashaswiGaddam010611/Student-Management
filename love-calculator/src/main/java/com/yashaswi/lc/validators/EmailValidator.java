package com.yashaswi.lc.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.yashaswi.lc.api.RegistrationDTO;

public class EmailValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return (RegistrationDTO.class).equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		String email = ((RegistrationDTO)target).getCommunicationDTO().getMail();
		
		if(email == null || email.isEmpty()) {
			errors.rejectValue("communicationDTO.mail", "registration.communication.mail.empty");
		} else {
			
			String defaultMailPostFix = "@gmail.com";
			int startIndex = email.length()-defaultMailPostFix.length();
			String mailPostFix = email.substring(startIndex);
			
			if(!defaultMailPostFix.equals(mailPostFix)) {
				errors.rejectValue("communicationDTO.mail", "registration.communication.mail.invalid");
			}
		}

	}

}
