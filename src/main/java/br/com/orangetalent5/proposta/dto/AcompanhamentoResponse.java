package br.com.orangetalent5.proposta.dto;

import br.com.orangetalent5.proposta.domain.EstadoProposta;
import br.com.orangetalent5.proposta.domain.Proposta;

public class AcompanhamentoResponse {

	private String documento;
	private String nome;
	private String idProposta;
	private EstadoProposta estadoProposta;
	
	public AcompanhamentoResponse() {
	}
	
	public AcompanhamentoResponse(Proposta proposta) {
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.idProposta = proposta.getId().toString();
		this.estadoProposta = proposta.getStatusProposta();
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
}
