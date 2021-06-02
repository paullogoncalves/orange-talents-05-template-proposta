package br.com.orangetalent5.proposta;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalent5.proposta.domain.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

}
