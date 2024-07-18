package com.yashaswi.lc.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {
	private int upper;
	private int lower;

	public void initialize(Age age) {
		this.upper = age.upper();
		this.lower = age.lower();
	}

	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		if (age == null)
			return false;
		if (age < lower || age > upper)
			return false;
		return true;
	}

}
