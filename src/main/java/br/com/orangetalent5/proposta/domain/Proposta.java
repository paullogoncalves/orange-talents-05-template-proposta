package br.com.orangetalent5.proposta.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@Enumerated(EnumType.STRING)
	private EstadoProposta statusProposta;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartao_id", referencedColumnName = "id")
	private CartaoCredito cartao;

	public Proposta() {
	}

	public Proposta(String nome, String email, String documento, String endereco, BigDecimal salario, CartaoCredito cartao) {
		super();
		this.nome = nome;
		this.email = email;
		this.documento = documento;
		this.Endereco = endereco;
		this.salario = salario;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return Endereco;
	}
	public CartaoCredito getCartao() {
		return cartao;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	
	public EstadoProposta getStatusProposta() {
		return statusProposta;
	}

	public void atualizaProposta(ConsultaDadosResponse consultaRestricaoForm, CartaoCredito cartao) {

		if (consultaRestricaoForm.getResultadoSolicitacao().equals("COM_RESTRICAO")) {
			this.statusProposta = EstadoProposta.NAO_ELEGIVEL;
			this.cartao = cartao;
		}

		if (consultaRestricaoForm.getResultadoSolicitacao().equals("SEM_RESTRICAO")) {
			this.statusProposta = EstadoProposta.ELEGIVEL;
			this.cartao = cartao;
		}

	}

}
