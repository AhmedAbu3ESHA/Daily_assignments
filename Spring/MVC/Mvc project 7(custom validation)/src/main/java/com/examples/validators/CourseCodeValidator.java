package com.examples.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.examples.customanotations.CourseCode;

public class CourseCodeValidator implements ConstraintValidator<CourseCode, String> {
	
	private String prefix;
	
	public void intialize(CourseCode courseCode) {
		this.prefix=courseCode.value();
			
	}

	@Override
	public boolean isValid(String enteredValue, ConstraintValidatorContext context) {
      if( enteredValue!=null &&  enteredValue.startsWith(prefix)) {
			
			return true;
		}
		else {
		return false;
	}

}
}
