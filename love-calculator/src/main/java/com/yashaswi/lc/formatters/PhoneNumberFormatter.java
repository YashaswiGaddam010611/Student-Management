package com.yashaswi.lc.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.yashaswi.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	public String print(Phone phone, Locale locale) {
		String phoneNumber = phone.getCountryCode()+"-"+phone.getNumber();
		
		return phoneNumber;
	}

	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		String[] phoneNumberParts = completePhoneNumber.split("-");

		Phone phone = new Phone();

		int index = completePhoneNumber.indexOf("-");
		if (index == -1 || index == 0) {
			phone.setCountryCode("91");
			if(index == -1) phone.setNumber(completePhoneNumber);
			if(index == 0)phone.setNumber(phoneNumberParts[1]);
		} else {
			phone.setCountryCode(phoneNumberParts[0]);
			phone.setNumber(phoneNumberParts[1]);
		}
		return phone;
	}

}
