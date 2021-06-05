package br.com.orangetalent5.proposta.dto;

import java.time.LocalDateTime;

import br.com.orangetalent5.proposta.domain.CartaoCredito;

public class AssociacaoCartaoResponse {

	private String id;
	private LocalDateTime emitidoEm;
	private String titular;

	public AssociacaoCartaoResponse() {
	}

	public AssociacaoCartaoResponse(String id, LocalDateTime emitidoEm, String titular) {
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
	
	public CartaoCredito toEntity() {
		return new CartaoCredito(id, emitidoEm, titular);
	}

}
