package br.com.orangetalent5.proposta.dto;

import java.time.LocalDateTime;

import br.com.orangetalent5.proposta.domain.BloqueioCartao;

public class BloqueioCartaoResponse {

	private LocalDateTime instante;
	
	private Long id;

	private String userAgent;
	
	
	public BloqueioCartaoResponse() {
	}

	public BloqueioCartaoResponse(Long id, String userAgent) {
		this.id = id;
		this.userAgent = userAgent;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	public Long getId() {
		return id;
	}
	

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getUserAgent() {
		return userAgent;
	}
	
	public BloqueioCartao toEntity() {
		return new BloqueioCartao(LocalDateTime.now(), id, userAgent);
	}
	
}
