package br.com.orangetalent5.proposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalent5.proposta.domain.CarteiraDigital;

public interface CarteiraDigitalRepository extends JpaRepository<CarteiraDigital, Long>{

	CarteiraDigital findByCartaoId(Long id);
}
