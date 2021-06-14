

package br.com.orangetalent5.proposta.resources;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalent5.proposta.clientExterno.BloqueioCartaoClient;
import br.com.orangetalent5.proposta.domain.BloqueioCartao;
import br.com.orangetalent5.proposta.domain.CartaoCredito;
import br.com.orangetalent5.proposta.dto.BloqueioCartaoRequest;
import br.com.orangetalent5.proposta.dto.ResponseBloqueioDTO;
import br.com.orangetalent5.proposta.enums.SituacaoCartao;
import br.com.orangetalent5.proposta.repositories.BloqueioCartaoRepository;
import br.com.orangetalent5.proposta.repositories.CartaoRepository;

@RestController
@RequestMapping("/cartoes")
public class BloqueioCartaoController {
	
	@Autowired
	private BloqueioCartaoClient transacaoBloqueio;
	
	@Autowired
	private BloqueioCartaoRepository bloqueioRepo;
	
	@Autowired
	private CartaoRepository cartaoRepo;
	
	
	@PostMapping("/{id}/bloqueios")
	public ResponseEntity<?> bloqueio(@PathVariable(value = "id") String id,
			@Valid @RequestBody BloqueioCartaoRequest request) {
		
		CartaoCredito cartao = cartaoRepo.findByIdCartao(id);
		
		ResponseBloqueioDTO bloqueioResponse = transacaoBloqueio.bloqueioCartao(id, request);
		
		if (bloqueioResponse.getResultado().equals("FALHA")) {
			return ResponseEntity.notFound().build();
		}
		
		Long ipCliente = cartao.getProposta().getId();
		BloqueioCartao transacaoConcluida = new BloqueioCartao(LocalDateTime.now(), ipCliente,
				request.getSistemaResponsavel());
		cartao.setSituacaoCartao(SituacaoCartao.BLOQUEADO);
		bloqueioRepo.save(transacaoConcluida);
		
		return ResponseEntity.ok().build();
	}
}




