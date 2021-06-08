package br.com.orangetalent5.proposta.dto;

import java.time.LocalDateTime;
import java.util.Base64;

import javax.validation.constraints.NotBlank;

import br.com.orangetalent5.proposta.domain.Biometria;

public class BiometriaRequest {
	
	
	@NotBlank
	private String fingerPrint;
	private LocalDateTime date;


	public BiometriaRequest() {
	}

	public BiometriaRequest(@NotBlank String fingerPrint, LocalDateTime date) {
		this.fingerPrint = fingerPrint;
		this.date = date;
		
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public LocalDateTime getDate() {
		return LocalDateTime.now();
	}
	
	private String firePrintEncoded() {
		return Base64.getEncoder().encodeToString(this.fingerPrint.getBytes());
	}

	public Biometria toEntity() {
		return new Biometria(firePrintEncoded(), getDate());
	}
}
