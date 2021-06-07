//import java.net.URI;
//
//import br.com.orangetalent5.proposta.domain.CartaoCredito;
//import br.com.orangetalent5.proposta.dto.AssociacaoCartaoResponse;

//package br.com.orangetalent5.proposta.resources;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////import br.com.orangetalent5.proposta.client.AssociacaoCartaoClient;
//import br.com.orangetalent5.proposta.client.ConsultaDadosClient;
//import br.com.orangetalent5.proposta.dto.ConsultaDadosRequest;
//import br.com.orangetalent5.proposta.dto.ConsultaDadosResponse;
//
//@RestController
//@RequestMapping("/api/solicitacao")
//public class SolicitacaoCartaoController {
//
//	@Autowired
//	private ConsultaDadosClient client;
//	
//	@Autowired
//	private AssociacaoCartaoClient associacaoCliente;
//	
//	@PostMapping
//	public ResponseEntity<?> getAnalize(@RequestBody ConsultaDadosRequest request) {
//		System.out.println("passou aui");
//		ConsultaDadosResponse soliResponse = client.getAnalise(request);
//		String soliResponse = "SEM_RESTRICAO";
//		if (soliResponse.getResultadoSolicitacao().equals("SEM_RESTRICAO")) {
//			AssociacaoCartaoResponse assCartao = associacaoCliente.getAnalise(request);
//			return ResponseEntity.ok().body(assCartao);
//		}
//		String retorno = "Deu certo";
//		System.out.println("tamb"); 
//		return ResponseEntity.ok().body(retorno);
//	}
//}



//if (consultaResponse.getResultadoSolicitacao().equals("SEM_RESTRICAO")) {
//		AssociacaoCartaoResponse associaRespo = associaClient.juntaCartao(propostaResponse);
//		CartaoCredito cartaoSalvo = cartaoRepo.save(associaRespo.toEntity(associaRespo, propostaNova));
//		}
//		
//		executor.atualizaEComita(propostaNova);
//		URI enderecoConsulta = builder.path("/{id}").build(propostaNova.getId());
