package br.com.orangetalent5.proposta.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.orangetalent5.proposta.domain.CartaoCredito;
import br.com.orangetalent5.proposta.domain.CarteiraDigital;
import br.com.orangetalent5.proposta.domain.CarteiraDigitalSansungPay;

public class CarteiraDigitalSansungPayRequest {
	
	@NotEmpty
	@Email
	private String email;
	@NotBlank
	private String carteira;
	
	public CarteiraDigitalSansungPayRequest() {
	}

	public CarteiraDigitalSansungPayRequest(@NotBlank String email, @NotBlank String carteira) {
		this.email = email;
		this.carteira = carteira;
	}

	public String getEmail() {
		return email;
	}

	public String getCarteira() {
		return carteira;
	}
	
	public CarteiraDigitalSansungPay toEntity(String idCateira, CartaoCredito cartao) {
		return new CarteiraDigitalSansungPay(email, carteira, idCateira, cartao);
	}
}
