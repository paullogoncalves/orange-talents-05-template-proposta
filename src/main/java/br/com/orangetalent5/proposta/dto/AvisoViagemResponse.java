package br.com.orangetalent5.proposta.dto;

import java.time.LocalDate;

public class AvisoViagemResponse {

	private String destino;
	
	private LocalDate validoAte;
	
	public AvisoViagemResponse(AvisoViagemRequest request) {
		this.destino = request.getDestinoViagem();
		this.validoAte = request.getTerminoViagem();
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getValidoAte() {
		return validoAte;
	}

}
