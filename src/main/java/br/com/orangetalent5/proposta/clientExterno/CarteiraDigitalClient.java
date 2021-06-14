package br.com.orangetalent5.proposta.clientExterno;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalent5.proposta.dto.CarteiraDigitalRequest;
import br.com.orangetalent5.proposta.dto.CarteiraDigitalResponseClient;
import feign.Headers;

@RestController
@FeignClient(name = "carteiraDigital", url = "http://localhost:8888")
public interface CarteiraDigitalClient {

	@PostMapping(value = "/api/cartoes/{idCartao}/carteiras", consumes = MediaType.APPLICATION_JSON_VALUE )
	@Headers("Content-Type: " + MediaType.APPLICATION_JSON_VALUE)
	CarteiraDigitalResponseClient associaCarteiraAndCartao(@PathVariable String idCartao, @RequestBody CarteiraDigitalRequest request);
}
