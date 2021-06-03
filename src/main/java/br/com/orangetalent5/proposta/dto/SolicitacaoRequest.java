package br.com.orangetalent5.proposta.dto;

public class SolicitacaoRequest {

	private String documento;
	private String nome;
	private String idProposta;
	
	public SolicitacaoRequest() {
	}
	
	public SolicitacaoRequest(String documento, String nome, String idProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
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

	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}

}
