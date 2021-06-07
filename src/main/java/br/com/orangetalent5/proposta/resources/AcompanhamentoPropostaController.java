package br.com.orangetalent5.proposta.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalent5.proposta.domain.Proposta;
import br.com.orangetalent5.proposta.dto.AcompanhamentoResponse;
import br.com.orangetalent5.proposta.dto.AtrelaCartaoResponse;
import br.com.orangetalent5.proposta.repositories.PropostaRepository;

@RestController
@RequestMapping("/estadoProposta")
public class AcompanhamentoPropostaController {
	
	@Autowired
	private PropostaRepository propostaRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<AcompanhamentoResponse> getCartao(@PathVariable("id") Long id) {		
		Optional<Proposta> proposta = propostaRepo.findById(id);
		
		if (proposta.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		AcompanhamentoResponse response = new AcompanhamentoResponse(proposta);

		return ResponseEntity.ok().body(response);
	}
}
