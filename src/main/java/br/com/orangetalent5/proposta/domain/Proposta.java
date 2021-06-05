package br.com.orangetalent5.proposta.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.orangetalent5.proposta.dto.ConsultaDadosResponse;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String documento;
	private String Endereco;
	private BigDecimal salario;

	private EstadoProposta statusProposta;

	@OneToOne
	private CartaoCredito cartao;

	public Proposta() {
	}

	public Proposta(String nome, String email, String documento, String endereco, BigDecimal salario) {
		super();
		this.nome = nome;
		this.email = email;
		this.documento = documento;
		Endereco = endereco;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

	public CartaoCredito getCartao() {
		return cartao;
	}

	public void atualizaEstadoProposta(ConsultaDadosResponse consultaRestricaoForm) {

		if (consultaRestricaoForm.getResultadoSolicitacao().equals("COM_RESTRICAO")) {
			this.statusProposta = EstadoProposta.NAO_ELEGIVEL;
		}

		if (consultaRestricaoForm.getResultadoSolicitacao().equals("SEM_RESTRICAO")) {
			this.statusProposta = EstadoProposta.ELEGIVEL;
		}

	}

}
