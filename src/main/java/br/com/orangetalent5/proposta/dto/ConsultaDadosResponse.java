package br.com.orangetalent5.proposta.dto;

public class ConsultaDadosResponse {

	private String documento;
	private String nome;
	private String resultadoSolicitacao;
	private String idProposta;

	public ConsultaDadosResponse() {
	}

	public ConsultaDadosResponse(String documento, String nome, String resultadoSolicitacao, String idProposta) {
		this.documento = documento;
		this.nome = nome;
		this.resultadoSolicitacao = resultadoSolicitacao;
		this.idProposta = idProposta;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setResultadoSolicitacao(String resultadoSolicitacao) {
		this.resultadoSolicitacao = resultadoSolicitacao;
	}

	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}
	
	

}
