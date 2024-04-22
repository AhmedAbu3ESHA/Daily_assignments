package com.examples.customanotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.examples.validators.CourseCodeValidator;

@Constraint( validatedBy= CourseCodeValidator.class)
@Target    ({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//define default course code

	String value() default "LUV";
	////define default error message
	public String message() default "must start with LUV";
	
	Class<?>[] groups()  default{};  //must be included
	
	Class<? extends Payload>[] payload()  default{};   //must be included

	
}
