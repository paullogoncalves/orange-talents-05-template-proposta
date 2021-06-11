package br.com.orangetalent5.proposta.dto;

import javax.validation.constraints.NotBlank;

public class BloqueioCartaoRequest {

	@NotBlank
	private String sistemaResponsavel;

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}


}
