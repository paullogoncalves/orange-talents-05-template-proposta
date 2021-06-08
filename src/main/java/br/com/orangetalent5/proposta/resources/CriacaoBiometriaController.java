package br.com.orangetalent5.proposta.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orangetalent5.proposta.domain.Biometria;
import br.com.orangetalent5.proposta.domain.CartaoCredito;
import br.com.orangetalent5.proposta.dto.BiometriaRequest;
import br.com.orangetalent5.proposta.repositories.BiometriaRepository;
import br.com.orangetalent5.proposta.repositories.CartaoRepository;

@RestController
@RequestMapping("/biometrias")
public class CriacaoBiometriaController {
	
	@Autowired
	private CartaoRepository cartaoRepo;
	
	@Autowired
	private BiometriaRepository biometriaRepo;
	
	@PostMapping("/{idCartao}")
	public ResponseEntity<Biometria> criaBiometria(@PathVariable("idCartao") String idCartao, 
			@Valid @RequestBody BiometriaRequest bioRequest, UriComponentsBuilder uriBuilder) {		
	
		CartaoCredito cartao = cartaoRepo.findByIdCartao(idCartao);
		if (cartao == null) {
			return ResponseEntity.notFound().build();
		}
		Biometria bio = bioRequest.toEntity();
		
		cartaoRepo.save(cartao);
		cartao.getBiometria().add(bio);
		biometriaRepo.save(bio);
		
		URI enderecoBiometria = uriBuilder.path("/biometrias/{idCartao}").build(bio.getId());
		return ResponseEntity.created(enderecoBiometria).build();
	}
}
