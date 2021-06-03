//package br.com.orangetalent5.proposta.validation;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import br.com.orangetalent5.proposta.domain.Proposta;
//import br.com.orangetalent5.proposta.dto.PropostaRequest;
//import br.com.orangetalent5.proposta.exception.FieldMessage;
//import br.com.orangetalent5.proposta.repositories.PropostaRepository;
//
//@Component
//public class PropostaExistenteValidator implements ConstraintValidator<PropostaExistente, PropostaRequest> {
//
//	private String domainAttribute;
//	private Class<?> klass;
//	
//	@Autowired
//	private PropostaRepository propostaRepo;
//
//	@PersistenceContext
//	private EntityManager manager;
//	
//	@Override
//	public void initialize(PropostaExistente ann) {
//		domainAttribute = ann.fieldName();
//		klass = ann.domainClass();
//		
//	}
//
//	@Override
//	public boolean isValid(PropostaRequest request, ConstraintValidatorContext context) {
//		//List<FieldMessage> listField = new ArrayList<>();
//		
//		Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + "=:value");
//		query.setParameter("value", request);
//		List<?> list = query.getResultList();
//		
//		listField.add(new FieldMessage("Documento", "Proposta já existente"));
//		Proposta aux = propostaRepo.findByDocumento(((PropostaRequest) request).getDocumento());
//		if (aux != null) {
//			listField.add(new FieldMessage("Documento", "Proposta já existente"));
//		}
//		
//		Assert.state(list.size() <= 1, domainAttribute + "Já existente");
//		
//		for (FieldMessage e : listField) {
//			context.disableDefaultConstraintViolation();
//			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
//					.addConstraintViolation();
//		}
//
//		return listField.isEmpty();
//	}
//}
