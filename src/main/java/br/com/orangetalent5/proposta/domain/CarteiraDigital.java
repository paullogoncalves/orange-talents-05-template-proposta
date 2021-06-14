package br.com.orangetalent5.proposta.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CarteiraDigital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	private String carteiraDigital;
	private String idCarteira;

	@OneToOne
	private CartaoCredito cartao;

	public CarteiraDigital() {
	}

	public CarteiraDigital(String email, String carteiraDigital, String idCarteira, CartaoCredito cartao) {
		this.email = email;
		this.carteiraDigital = carteiraDigital;
		this.idCarteira = idCarteira;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCarteiraDigital() {
		return carteiraDigital;
	}

	public void setCarteiraDigital(String carteiraDigital) {
		this.carteiraDigital = carteiraDigital;
	}

	public String getIdCarteira() {
		return idCarteira;
	}

	public void setIdCarteira(String idCarteira) {
		this.idCarteira = idCarteira;
	}

	public CartaoCredito getCartao() {
		return cartao;
	}

	public void setCartao(CartaoCredito cartao) {
		this.cartao = cartao;
	}

}
