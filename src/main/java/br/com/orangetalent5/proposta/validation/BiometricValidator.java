package br.com.orangetalent5.proposta.validation;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.orangetalent5.proposta.dto.BiometriaRequest;
import br.com.orangetalent5.proposta.exception.FieldMessage;
import br.com.orangetalent5.proposta.repositories.PropostaRepository;

@Component
public class BiometricValidator implements ConstraintValidator<Biometric, BiometriaRequest> {

	private String domainAttribute;
	private Class<?> klass;

	@Autowired
	private PropostaRepository propostaRepo;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(Biometric ann) {	
	}

	@Override
	public boolean isValid(BiometriaRequest request, ConstraintValidatorContext context) {
		List<FieldMessage> listField = new ArrayList<>();
		

		boolean biometria = testStringIsBase64(request.getFingerPrint());

		if (biometria == false) {
			listField.add(new FieldMessage("fingerPrint", "Biometria inválida"));
		}
		
		for (FieldMessage e : listField) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return listField.isEmpty();
	}
	
	private boolean testStringIsBase64(String input) {
		  boolean result = false;
		  String test;
		  try {
		    test = convertStringFromBase64(input);
		    if (input.equals(convertStringToBase64(test))) {
		      result = true;
		    }
		  }
		  catch (Exception ex) {
		    result = false;
		  }
		  return result;
		}

	private String convertStringToBase64(String input) {
		return Base64.getEncoder().encodeToString(input.getBytes());
	}

	private String convertStringFromBase64(String input) {
		return new String(Base64.getDecoder().decode(input));
	}

}
