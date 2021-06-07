package br.com.orangetalent5.proposta.dto;

import br.com.orangetalent5.proposta.domain.Proposta;

public class PropostaResponse {

	private String documento;
	private String nome;
	private String idProposta;
	
	public PropostaResponse() {
	}
	
	public PropostaResponse(Proposta proposta) {
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.idProposta = proposta.getId().toString();
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
	

}