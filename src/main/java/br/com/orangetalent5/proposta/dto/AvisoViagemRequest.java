package br.com.orangetalent5.proposta.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import br.com.orangetalent5.proposta.domain.AvisoViagem;
import br.com.orangetalent5.proposta.domain.CartaoCredito;

public class AvisoViagemRequest {

	@NotBlank
	private String destinoViagem;
	
	@NotBlank
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate terminoViagem;
	
	@NotNull
	private Long ipCliente;
	@NotBlank
	private String userAgent;
	
	public AvisoViagemRequest() {
	}

	public AvisoViagemRequest(@NotBlank String destinoViagem, @NotBlank LocalDate terminoViagem, String userAgent) {
		this.destinoViagem = destinoViagem;
		this.terminoViagem = terminoViagem;
		this.userAgent= userAgent;
	}
	
	public AvisoViagem toEntity(CartaoCredito cartao) {
		return new AvisoViagem(LocalDateTime.now(), ipCliente, userAgent, cartao);
	}

	public String getDestinoViagem() {
		return destinoViagem;
	}

	public LocalDate getTerminoViagem() {
		return terminoViagem;
	}

	public Long getIpCliente() {
		return ipCliente;
	}

	public String getUserAgent() {
		return userAgent;
	}
	
	
}
