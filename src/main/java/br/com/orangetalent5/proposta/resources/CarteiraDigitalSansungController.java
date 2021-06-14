package br.com.orangetalent5.proposta.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orangetalent5.proposta.clientExterno.CarteiraDigitalClient;
import br.com.orangetalent5.proposta.domain.CartaoCredito;
import br.com.orangetalent5.proposta.domain.CarteiraDigitalSansungPay;
import br.com.orangetalent5.proposta.dto.CarteiraDigitalResponseClient;
import br.com.orangetalent5.proposta.dto.CarteiraDigitalSansungPayRequest;
import br.com.orangetalent5.proposta.repositories.CartaoRepository;
import br.com.orangetalent5.proposta.repositories.CarteiraDigitalSansungRepository;

@RestController
@RequestMapping("/")
public class CarteiraDigitalSansungController {

	@Autowired
	private CartaoRepository cartaoRepo;
	
	@Autowired
	private CarteiraDigitalSansungRepository carteiraRepo;
	
	@Autowired
	private CarteiraDigitalClient carteiraClient;
	
	@PostMapping("{id}/sansung")
	public ResponseEntity<?> create(@PathVariable(value = "id") String id, @RequestBody CarteiraDigitalSansungPayRequest request,
			UriComponentsBuilder uriBuilder) {
		
		CartaoCredito cartao = cartaoRepo.findByIdCartao(id);

	    System.out.println("asss");	
		CarteiraDigitalResponseClient response = carteiraClient.associaCarteiraSansungAndCartao(id, request);

		CarteiraDigitalSansungPay carteiraFinal = request.toEntity(response.getId(), cartao);
		
		carteiraRepo.save(carteiraFinal);
		URI uri = uriBuilder.path("/{id}/carteiras").build(carteiraFinal.getId());
		return ResponseEntity.created(uri).build();
	}
}
