package br.com.orangetalent5.proposta.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.orangetalent5.proposta.client.AssociacaoCartaoClient;
import br.com.orangetalent5.proposta.client.ConsultaDadosClient;
import br.com.orangetalent5.proposta.domain.CartaoCredito;
import br.com.orangetalent5.proposta.domain.Proposta;
import br.com.orangetalent5.proposta.dto.AssociacaoCartaoResponse;
import br.com.orangetalent5.proposta.dto.ConsultaDadosRequest;
import br.com.orangetalent5.proposta.dto.ConsultaDadosResponse;
import br.com.orangetalent5.proposta.dto.PropostaRequest;
import br.com.orangetalent5.proposta.exception.ExistingDocumentException;
import br.com.orangetalent5.proposta.repositories.CartaoRepository;
import br.com.orangetalent5.proposta.repositories.PropostaRepository;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

	@Autowired
	public PropostaRepository propostaRepo;
	
	@Autowired
	private ConsultaDadosClient consultaClient;
	
	@Autowired
	private AssociacaoCartaoClient associaClient;
	
	@Autowired
	private CartaoRepository cartaoRepo;
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> create(@Valid @RequestBody PropostaRequest request) {
		
		Proposta propostaNova = request.toEntity();
		Proposta propostaExistente = propostaRepo.findByDocumento(request.getDocumento());
		if (propostaExistente != null) {
			throw new ExistingDocumentException();
		}
		propostaRepo.save(propostaNova);
		
		ConsultaDadosResponse consultaResponse = ConsultaDadosAndAtrelaCartão(propostaNova);
		
		propostaNova.atualizaEstadoProposta(consultaResponse);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(propostaNova.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	private ConsultaDadosResponse ConsultaDadosAndAtrelaCartão(Proposta propostaNova) {
		ConsultaDadosRequest consultaRequest = new ConsultaDadosRequest(propostaNova);
		ConsultaDadosResponse consultaResponse = consultaClient.getAnalise(consultaRequest);
		
		AssociacaoCartaoResponse associaRespo = associaClient.juntaCartao(consultaRequest);
		
		CartaoCredito cartao = associaRespo.toEntity();
		
		cartaoRepo.save(cartao);
		System.out.println(cartao.getId()); 
		return consultaResponse;
	}
}
