/**
 * 
 */
package edu.mum.cs.cs544.ocr.validator;

import edu.mum.cs.cs544.ocr.domain.Credentials;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Vivian Samson
 *
 */
public class PasswordEqualValidator implements ConstraintValidator<PasswordsEqualConstraint, Object> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(PasswordsEqualConstraint constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Object Credentials, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		Credentials credential = (Credentials) Credentials;
		System.out.println(credential.getVerifyPassword() + " " +  credential.getPassword() );
		return credential.getPassword().equals(credential.getVerifyPassword());
		
	}

}
