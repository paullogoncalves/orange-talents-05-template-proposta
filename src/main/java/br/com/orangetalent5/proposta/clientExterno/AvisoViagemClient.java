//package br.com.orangetalent5.proposta.clientExterno;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.orangetalent5.proposta.dto.AvisoViagemResponse;
//import br.com.orangetalent5.proposta.dto.ResponseBloqueioDTO;
//import feign.Headers;
//
//@RestController
//@FeignClient(name = "avisoViagem", url = "http://localhost:8888")
//public interface AvisoViagemClient {
//
//	@PostMapping(value = "/api/cartoes/{idCartao}/avisos", consumes = MediaType.APPLICATION_JSON_VALUE )
//	@Headers("Content-Type: " + MediaType.APPLICATION_JSON_VALUE)
//	ResponseBloqueioDTO bloqueioCartao(@PathVariable String idCartao, @RequestBody AvisoViagemResponse response);
//}
