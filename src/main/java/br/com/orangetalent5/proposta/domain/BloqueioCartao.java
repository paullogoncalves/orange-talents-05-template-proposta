package br.com.orangetalent5.proposta.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BloqueioCartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime instante;
	
	private Long idCliente;
	
	private String UserAgent;
	
	public BloqueioCartao() {
	}

	public BloqueioCartao(LocalDateTime instante, Long idCliente, String userAgent) {
		this.instante = instante;
		this.idCliente = idCliente;
		this.UserAgent = userAgent;
	}
	
	
}
