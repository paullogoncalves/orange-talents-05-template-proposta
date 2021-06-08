package br.com.orangetalent5.proposta.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany
	@JoinColumn(name = "cartao_id")
	private List<Biometria> biometria;
	
	public CartaoCredito() {
	}

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
	
	public List<Biometria> getBiometria() {
		return biometria;
	}
	
	
	
	
//	val status = resultadoSolicitacao.toModel() // roda aquela logica dentro do DTO

}
