package br.com.orangetalent5.proposta.dto;

import java.util.Optional;

import br.com.orangetalent5.proposta.domain.EstadoProposta;
import br.com.orangetalent5.proposta.domain.Proposta;

public class AcompanhamentoResponse {

	private String documento;
	private String nome;
	private String idProposta;
	private EstadoProposta estadoProposta;
	private String numeroCartao;
	
	public AcompanhamentoResponse() {
	}
	
	public AcompanhamentoResponse(Optional<Proposta> proposta) {
		this.documento = proposta.get().getDocumento();
		this.nome = proposta.get().getNome();
		this.idProposta = proposta.get().getId().toString();
		this.estadoProposta = proposta.get().getStatusProposta();
		this.numeroCartao = proposta.get().getCartao().getIdCartao();
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdProposta() {
		return idProposta;
	}
	
	public EstadoProposta getEstadoProposta() {
		return estadoProposta;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}
}
