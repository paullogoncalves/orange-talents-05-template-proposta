package br.com.orangetalent5.proposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalent5.proposta.domain.CartaoCredito;

public interface CartaoRepository extends JpaRepository<CartaoCredito, Long>{

	CartaoCredito findByIdCartao(String idCartao);
}
