package br.com.orangetalent5.proposta.dto;

import java.time.LocalDateTime;

import br.com.orangetalent5.proposta.domain.CartaoCredito;
import br.com.orangetalent5.proposta.domain.Proposta;
import br.com.orangetalent5.proposta.enums.SituacaoCartao;

public class AtrelaCartaoResponse {

	private String id;
	private LocalDateTime emitidoEm;
	private String titular;

	public AtrelaCartaoResponse() {
	}

	public AtrelaCartaoResponse(String id, LocalDateTime emitidoEm, String titular) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}
	
	public CartaoCredito toEntity(AtrelaCartaoResponse associacao) {
		return new CartaoCredito(associacao.getId(), associacao.emitidoEm, associacao.titular, SituacaoCartao.ATIVO);
	}

}
