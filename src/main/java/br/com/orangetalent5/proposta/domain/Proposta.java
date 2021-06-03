package br.com.orangetalent5.proposta.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
