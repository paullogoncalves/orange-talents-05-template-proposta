package br.com.orangetalent5.proposta.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.orangetalent5.proposta.domain.Proposta;
import br.com.orangetalent5.proposta.validation.CPFOrCNPJ;

//@PropostaExistente
public class PropostaRequest {
	@NotBlank
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
		this.nome = nome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public String getDocumento() {
		return documento;
	}
	 
	public Proposta toEntity(String documento) {
		
		return new Proposta(nome, email, documento , endereco, salario, null);
	}


	
}
