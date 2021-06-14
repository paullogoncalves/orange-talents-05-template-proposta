package br.com.orangetalent5.proposta.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.orangetalent5.proposta.enums.SituacaoCartao;

@Entity
public class CartaoCredito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String idCartao;
	private LocalDateTime emitidoEm;
	private String titular;
	
	@OneToOne(mappedBy = "cartao")
	private Proposta proposta;
	
	@OneToMany
	@JoinColumn(name = "cartao_id")
	private List<Biometria> biometria;
	
	@Enumerated(EnumType.STRING)
	private SituacaoCartao situacaoCartao;
	
	@OneToMany(mappedBy = "cartao")
	private List<AvisoViagem> avisoViagem;
	
	@OneToOne
	private CarteiraDigital carteira;
	
	@OneToOne
	private CarteiraDigitalSansungPay sansungPay;
	
	public CartaoCredito() {
	}

	public CartaoCredito(String idCartao, LocalDateTime emitidoEm, String titular, SituacaoCartao situacaoCartao) {
		this.idCartao = idCartao;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.setSituacaoCartao(situacaoCartao);
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

	public void setSituacaoCartao(SituacaoCartao situacaoCartao) {
		this.situacaoCartao = situacaoCartao;
	}
	
	
	
	
	
//	val status = resultadoSolicitacao.toModel() // roda aquela logica dentro do DTO

}
