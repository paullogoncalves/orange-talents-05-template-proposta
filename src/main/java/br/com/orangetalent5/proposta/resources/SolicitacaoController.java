//package br.com.orangetalent5.proposta.resources;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.orangetalent5.proposta.client.SolicitacaoClient;
//import br.com.orangetalent5.proposta.domain.Proposta;
//import br.com.orangetalent5.proposta.dto.SolicitacaoRequest;
//import br.com.orangetalent5.proposta.dto.SolicitacaoResponse;
//
//@RestController
//@RequestMapping("/api/solicitacao")
//public class SolicitacaoController {
//
//	@Autowired
//	private SolicitacaoClient client;
//	
//	@Autowired
//	private Proposta propostaRepo;
//	
//	@PostMapping
//	public ResponseEntity<SolicitacaoResponse> getAnalize(@RequestBody SolicitacaoRequest request) {
//		System.out.println("passou aui");
//		
//		
//		
//		SolicitacaoResponse soli = client.getAnalize(request);
//		
//		
//		return ResponseEntity.ok().body(soli);
//	}
//}
