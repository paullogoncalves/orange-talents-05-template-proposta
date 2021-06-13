package br.com.orangetalent5.proposta.dto;

import java.time.LocalDateTime;
import java.util.Base64;

import javax.validation.constraints.NotBlank;

import br.com.orangetalent5.proposta.domain.Biometria;
import br.com.orangetalent5.proposta.validation.Biometric;

@Biometric
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
	
	public Biometria toEntity() {
		return new Biometria(this.fingerPrint, getDate());
	}
}
