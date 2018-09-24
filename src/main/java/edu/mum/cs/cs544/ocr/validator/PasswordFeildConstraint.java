/**
 * 
 */
package edu.mum.cs.cs544.ocr.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Vivian Samson
 *
 */
@Target( { METHOD, FIELD, ElementType.TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordFeildValidator.class)
@Documented
public @interface PasswordFeildConstraint {

	String message() default "{PasswordNotValid}";

    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
