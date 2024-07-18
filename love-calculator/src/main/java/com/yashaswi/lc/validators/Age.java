package com.yashaswi.lc.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
	String message() default "{ageValidationErrorMessage}";

	int upper() default 18;

	int lower() default 60;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
