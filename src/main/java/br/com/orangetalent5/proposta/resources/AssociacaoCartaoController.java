//package br.com.orangetalent5.proposta.resources;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.orangetalent5.proposta.client.AssociacaoCartaoClient;
//import br.com.orangetalent5.proposta.dto.AssociacaoCartaoResponse;
//import br.com.orangetalent5.proposta.dto.SolicitacaoCartaoResponse;
//
//@RestController
//@RequestMapping("/api/cartoes")
//public class AssociacaoCartaoController {
//
//	@Autowired
//	private AssociacaoCartaoClient client;
//	
//	@GetMapping
//	public ResponseEntity<AssociacaoCartaoResponse> getCartao() {
//		System.out.println("passou aui");
//		AssociacaoCartaoResponse response = client.getCartao();
//		return ResponseEntity.ok().body(response);
//	}
//}
