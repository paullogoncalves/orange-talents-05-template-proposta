//package br.com.orangetalent5.proposta.validation;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//
//
//@Constraint(validatedBy = PropostaExistenteValidator.class)
//@Target({ ElementType.TYPE })
//@Retention(RetentionPolicy.RUNTIME)
//public @interface PropostaExistente {
//	String message() default "pppp";
//	
//	Class<?>[] groups() default {};
//
//	Class<? extends Payload>[] payload() default {};
//	
//
//}