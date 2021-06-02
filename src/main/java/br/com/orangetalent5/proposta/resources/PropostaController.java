package br.com.orangetalent5.proposta.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalent5.proposta.domain.Proposta;
import br.com.orangetalent5.proposta.domain.PropostaRequest;
import br.com.orangetalent5.proposta.repositories.PropostaRepository;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

	@Autowired
	public PropostaRepository propostaRepo;
	
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody @Valid PropostaRequest request) {
		Proposta propostaNova = request.toEntity();
		Proposta propostaExistente = propostaRepo.findByDocumento(request.getDocumento());
		if (propostaExistente != null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}
		propostaRepo.save(propostaNova);
		
		return ResponseEntity.ok().build();
	}
}
