package br.com.orangetalent5.proposta.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String msg) {
		this.errors.add(new FieldMessage(fieldName, msg));
	}

}
