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
import br.com.orangetalent5.proposta.domain.CarteiraDigital;
import br.com.orangetalent5.proposta.dto.CarteiraDigitalRequest;
import br.com.orangetalent5.proposta.dto.CarteiraDigitalResponseClient;
import br.com.orangetalent5.proposta.repositories.CartaoRepository;
import br.com.orangetalent5.proposta.repositories.CarteiraDigitalRepository;

@RestController
@RequestMapping("/")
public class CarteiraDigitalController {

	@Autowired
	private CartaoRepository cartaoRepo;
	
	@Autowired
	private CarteiraDigitalRepository carteiraRepo;
	
	@Autowired
	private CarteiraDigitalClient carteiraClient;
	
	@PostMapping("{id}/carteiras")
	public ResponseEntity<?> aviso(@PathVariable(value = "id") String id, @RequestBody CarteiraDigitalRequest request,
			UriComponentsBuilder uriBuilder) {
		
		CartaoCredito cartao = cartaoRepo.findByIdCartao(id);

		CarteiraDigital jaExisteCarteiraAssociada = carteiraRepo.findByCartaoId(cartao.getId());
		
		if (jaExisteCarteiraAssociada != null)	{
			return ResponseEntity.unprocessableEntity().build();
		}
				
		CarteiraDigitalResponseClient response = carteiraClient.associaCarteiraAndCartao(id, request);

		CarteiraDigital carteiraFinal = request.toEntity(response.getId(), cartao);
		
		carteiraRepo.save(carteiraFinal);
		URI uri = uriBuilder.path("/{id}/carteiras").build(carteiraFinal.getId());
		return ResponseEntity.ok().build();
	}
}
