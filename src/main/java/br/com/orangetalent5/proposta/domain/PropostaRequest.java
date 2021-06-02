package br.com.orangetalent5.proposta.domain;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.orangetalent5.proposta.validation.CPFOrCNPJ;
import br.com.orangetalent5.proposta.validation.PropostaExistente;

@PropostaExistente
public class PropostaRequest {
	@NotEmpty
	private String nome;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	
	@CPFOrCNPJ(domainClass = Proposta.class, fieldName = "documento")
	private String documento;
	@NotEmpty
	private String endereco;
	@NotNull
	@Positive
	private BigDecimal salario;

	public PropostaRequest() {
	}

	public PropostaRequest(@NotEmpty String nome, @NotEmpty @Email String email, @NotEmpty String documento,
			@NotEmpty String endereco, @NotEmpty @Positive BigDecimal salario) {
		super();
		this.nome = nome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Proposta toEntity() {
		return new Proposta(nome, email, getDocumento(), endereco, salario);
	}

	public String getDocumento() {
		return documento;
	}
	


}
