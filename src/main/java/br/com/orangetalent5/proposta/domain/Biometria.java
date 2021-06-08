package br.com.orangetalent5.proposta.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Biometria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String fingerPrint;
	private LocalDateTime date;
	
	@ManyToOne
	private CartaoCredito cartao;
	
	public Biometria() {
	}

	public Biometria(String fingerPrint, LocalDateTime date) {
		this.fingerPrint = fingerPrint;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public LocalDateTime getDate() {
		return date;
	}
	
	
	
}
