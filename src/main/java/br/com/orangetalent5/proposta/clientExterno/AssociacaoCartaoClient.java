package br.com.orangetalent5.proposta.clientExterno;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalent5.proposta.dto.AtrelaCartaoResponse;
import br.com.orangetalent5.proposta.dto.PropostaResponse;
import feign.Headers;

@RestController
@FeignClient(name = "cartoes", url = "http://localhost:8888")
public interface AssociacaoCartaoClient {

	@PostMapping(value = "/api/cartoes", consumes = MediaType.APPLICATION_JSON_VALUE )
	@Headers("Content-Type: " + MediaType.APPLICATION_JSON_VALUE)
	AtrelaCartaoResponse juntaCartao(@RequestBody PropostaResponse propostaResponse);
}
