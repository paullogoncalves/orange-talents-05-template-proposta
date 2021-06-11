package br.com.orangetalent5.proposta.clientExterno;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalent5.proposta.dto.BloqueioCartaoRequest;
import br.com.orangetalent5.proposta.dto.ResponseBloqueioDTO;
import feign.Headers;

@RestController
@FeignClient(name = "bloqueioCartoes", url = "http://localhost:8888")
public interface BloqueioCartaoClient {

	@PostMapping(value = "/api/cartoes/{idCartao}/bloqueios", consumes = MediaType.APPLICATION_JSON_VALUE )
	@Headers("Content-Type: " + MediaType.APPLICATION_JSON_VALUE)
	ResponseBloqueioDTO bloqueioCartao(@PathVariable String idCartao, @RequestBody BloqueioCartaoRequest request);
}
