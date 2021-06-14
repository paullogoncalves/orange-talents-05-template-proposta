package br.com.orangetalent5.proposta.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalent5.proposta.clientExterno.AvisoViagemClient;
import br.com.orangetalent5.proposta.domain.AvisoViagem;
import br.com.orangetalent5.proposta.domain.CartaoCredito;
import br.com.orangetalent5.proposta.dto.AvisoViagemRequest;
import br.com.orangetalent5.proposta.dto.AvisoViagemResponse;
import br.com.orangetalent5.proposta.repositories.AvisoViagemRepository;
import br.com.orangetalent5.proposta.repositories.CartaoRepository;

@RestController
@RequestMapping("/")
public class AvisoViagemController {

	@Autowired
	private AvisoViagemRepository viagemRepo;
	
	@Autowired
	private CartaoRepository cartaoRepo;
	
	@Autowired
	private AvisoViagemClient avisoViagemClient;
	
	@PostMapping("{id}/avisos")
	public ResponseEntity<?> aviso(@PathVariable(value = "id") String id, @RequestBody AvisoViagemRequest request) {
		CartaoCredito cartao = cartaoRepo.findByIdCartao(id);
		
		AvisoViagem aviso = request.toEntity(cartao);
		viagemRepo.save(aviso);
		
		AvisoViagemResponse response = new AvisoViagemResponse(request);
		
		avisoViagemClient.aviso(id, response);
		
		return ResponseEntity.ok().build();
	}
}
