package br.com.orangetalent5.proposta.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AvisoViagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime instante;
	private Long ipCliente;
	private String userAgente;
	
	@ManyToOne
	@JoinColumn(name = "cartao_id", referencedColumnName = "id")
	private CartaoCredito cartao;
	
	public AvisoViagem() {
	}

	public AvisoViagem(LocalDateTime instante, Long ipCliente, String userAgente, CartaoCredito cartao) {
		super();	
		this.instante = instante;
		this.ipCliente = ipCliente;
		this.userAgente = userAgente;
		this.cartao = cartao;
	}
	
	
}
