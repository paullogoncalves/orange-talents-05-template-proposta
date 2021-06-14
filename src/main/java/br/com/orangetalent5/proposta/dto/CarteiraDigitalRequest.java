package br.com.orangetalent5.proposta.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.orangetalent5.proposta.domain.CartaoCredito;
import br.com.orangetalent5.proposta.domain.CarteiraDigital;

public class CarteiraDigitalRequest {
	
	@NotEmpty
	@Email
	private String email;
	@NotBlank
	private String carteira;
	
	public CarteiraDigitalRequest() {
	}

	public CarteiraDigitalRequest(@NotBlank String email, @NotBlank String carteira) {
		this.email = email;
		this.carteira = carteira;
	}

	public String getEmail() {
		return email;
	}

	public String getCarteira() {
		return carteira;
	}
	
	public CarteiraDigital toEntity(String idCateira, CartaoCredito cartao) {
		return new CarteiraDigital(email, carteira, idCateira, cartao);
	}
}
