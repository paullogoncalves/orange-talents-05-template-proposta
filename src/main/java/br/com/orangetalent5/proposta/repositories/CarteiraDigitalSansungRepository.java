package br.com.orangetalent5.proposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalent5.proposta.domain.CarteiraDigital;
import br.com.orangetalent5.proposta.domain.CarteiraDigitalSansungPay;

public interface CarteiraDigitalSansungRepository extends JpaRepository<CarteiraDigitalSansungPay, Long>{

}
