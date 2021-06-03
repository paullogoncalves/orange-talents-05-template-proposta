package br.com.orangetalent5.proposta.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalent5.proposta.dto.SolicitacaoRequest;
import br.com.orangetalent5.proposta.dto.SolicitacaoResponse;
import feign.Headers;

@RestController
@FeignClient(name = "cliente", url = "http://localhost:9999")
public interface SolicitacaoClient {

	@PostMapping(value = "/api/solicitacao", consumes = MediaType.APPLICATION_JSON_VALUE )
	@Headers("Content-Type: " + MediaType.APPLICATION_JSON_VALUE)
	SolicitacaoResponse getAnalise(@RequestBody SolicitacaoRequest request);
}
