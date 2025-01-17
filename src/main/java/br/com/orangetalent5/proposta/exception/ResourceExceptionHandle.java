package br.com.orangetalent5.proposta.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import feign.FeignException;

@ControllerAdvice
public class ResourceExceptionHandle {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> documentException(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
	
	for (FieldError x : e.getBindingResult().getFieldErrors()) {
		err.addErrors(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<StandardError> documentException(ResponseStatusException e, HttpServletRequest request) {
		StandardError err = new ValidationError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), System.currentTimeMillis());
			
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
	
	@ExceptionHandler(ExistingDocumentException.class)
	public ResponseEntity<StandardError> documentException(ExistingDocumentException e, HttpServletRequest request) {
		StandardError err = new ValidationError(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Já existe uma proposta com esse documento", System.currentTimeMillis());
			
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
	
	@ExceptionHandler(FeignException.UnprocessableEntity.class)
	public ResponseEntity<StandardError> documentException(FeignException.UnprocessableEntity e, HttpServletRequest request) {
		StandardError err = new ValidationError(HttpStatus.UNPROCESSABLE_ENTITY.value(), "FALHA na tentativa de bloqueio do cartão", System.currentTimeMillis());
			
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
	
	@ExceptionHandler(FeignException.InternalServerError.class)
	public ResponseEntity<StandardError> documentException(FeignException.InternalServerError e, HttpServletRequest request) {
		StandardError err = new ValidationError(HttpStatus.NOT_FOUND.value(), "Cartão não encontrado", System.currentTimeMillis());
			
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	
}
