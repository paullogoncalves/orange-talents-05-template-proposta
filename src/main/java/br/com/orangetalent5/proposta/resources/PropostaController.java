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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orangetalent5.proposta.ExecutorTransacao;
import br.com.orangetalent5.proposta.client.AssociacaoCartaoClient;
import br.com.orangetalent5.proposta.client.ConsultaDadosClient;
import br.com.orangetalent5.proposta.domain.CartaoCredito;
import br.com.orangetalent5.proposta.domain.Proposta;
import br.com.orangetalent5.proposta.dto.AtrelaCartaoResponse;
import br.com.orangetalent5.proposta.dto.ConsultaDadosResponse;
import br.com.orangetalent5.proposta.dto.PropostaRequest;
import br.com.orangetalent5.proposta.dto.PropostaResponse;
import br.com.orangetalent5.proposta.exception.ExistingDocumentException;
import br.com.orangetalent5.proposta.repositories.CartaoRepository;
import br.com.orangetalent5.proposta.repositories.PropostaRepository;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

	private static final String COM_RESTRICAO = "COM_RESTRICAO";

	@Autowired
	public PropostaRepository propostaRepo;

	@Autowired
	private ConsultaDadosClient consultaClient;

	@Autowired
	private AssociacaoCartaoClient associaClient;

	@Autowired
	private CartaoRepository cartaoRepo;

	private PropostaResponse propostaResponse;
	
	@Autowired
	private ExecutorTransacao executor;

	@PostMapping
	@Transactional
	public ResponseEntity<Void> create(@Valid @RequestBody PropostaRequest request, UriComponentsBuilder builder) {
		Proposta propostaNova = request.toEntity();
		
		Proposta propostaExistente = propostaRepo.findByDocumento(request.getDocumento());
		if (propostaExistente != null) {
			throw new ExistingDocumentException();
		}
		propostaResponse = new PropostaResponse(executor.salvaEComita(propostaNova));

		ConsultaDadosResponse consultaResponse = consultaDadosAndTrataException();
	
		if (consultaResponse.getResultadoSolicitacao().equals(COM_RESTRICAO)) {
			propostaNova.atualizaProposta(consultaResponse, null);
		    URI enderecoConsulta = builder.path("/propostas/{id}").build(propostaNova.getId());	
			return ResponseEntity.created(enderecoConsulta).build();
			
		}
		
		AtrelaCartaoResponse atrelaCartaoResponse = associaClient.juntaCartao(propostaResponse);
		CartaoCredito cartaoSalvo = cartaoRepo.save(atrelaCartaoResponse.toEntity(atrelaCartaoResponse));

		propostaNova.atualizaProposta(consultaResponse, cartaoSalvo);
		executor.atualizaEComita(propostaNova);

		URI enderecoConsulta = builder.path("/propostas/{id}").build(propostaNova.getId());	
		return ResponseEntity.created(enderecoConsulta).build();
	}

	private ConsultaDadosResponse consultaDadosAndTrataException() {
		ConsultaDadosResponse consultaResponse;

		try {
			consultaResponse = consultaClient.getAnalise(propostaResponse);
		} catch (Exception e) {
			return consultaResponse = new ConsultaDadosResponse(propostaResponse.getDocumento(),
					propostaResponse.getNome(), COM_RESTRICAO, propostaResponse.getIdProposta());
		}

		return consultaResponse;
	}
}
