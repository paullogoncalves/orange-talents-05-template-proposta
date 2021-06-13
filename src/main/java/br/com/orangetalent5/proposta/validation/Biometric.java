package br.com.orangetalent5.proposta.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = BiometricValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Biometric {
	String message() default "Biometria";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	

}