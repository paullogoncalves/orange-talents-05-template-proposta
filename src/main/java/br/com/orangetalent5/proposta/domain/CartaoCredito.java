package br.com.orangetalent5.proposta.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CartaoCredito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String idCartao;
	private LocalDateTime emitidoEm;
	private String titular;
	@OneToOne
	private Proposta proposta;

	public CartaoCredito(String idCartao, LocalDateTime emitidoEm, String titular) {
		this.idCartao = idCartao;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
	}

	public Long getId() {
		return id;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public Proposta getProposta() {
		return proposta;
	}
	
	
	
	
	
//	val status = resultadoSolicitacao.toModel() // roda aquela logica dentro do DTO

}
