package br.com.orangetalent5.proposta.clientExterno;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.orangetalent5.proposta.dto.ConsultaDadosResponse;
import br.com.orangetalent5.proposta.dto.PropostaResponse;
import feign.Headers;

@ResponseStatus
@FeignClient(name = "cliente", url = "${solicitacao.analise.endpoint}")
public interface ConsultaDadosClient {

	@PostMapping(value = "/api/solicitacao", consumes = MediaType.APPLICATION_JSON_VALUE )
	@Headers("Content-Type: " + MediaType.APPLICATION_JSON_VALUE)
	ConsultaDadosResponse getAnalise(@RequestBody PropostaResponse propostaResponse);
}
