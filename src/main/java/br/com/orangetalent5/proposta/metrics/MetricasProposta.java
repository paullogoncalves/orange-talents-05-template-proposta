package br.com.orangetalent5.proposta.metrics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.lang.Objects;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;

@Component
public class MetricasProposta {

	private final MeterRegistry meterRegistry;

	private final Collection<String> strings = new ArrayList<>();

	private final Random random = new Random();

	public MetricasProposta(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
		criarGauge();
	}

	public void meuContador() {
		Collection<Tag> tags = new ArrayList<>();
		tags.add(Tag.of("emissora", "Mastercard"));
		tags.add(Tag.of("banco", "Itaú"));

		Counter contadorDePropostasCriadas = this.meterRegistry.counter("proposta_criada", tags);
		contadorDePropostasCriadas.increment();
	}
	
	public void criarGauge() {
        Collection<Tag> tags = new ArrayList<>();
        tags.add(Tag.of("emissora", "Mastercard"));
        tags.add(Tag.of("banco", "Itaú"));

        this.meterRegistry.gauge("meu_gauge", tags, strings, Collection::size);
    }
	
	public void addString() {
	    strings.add(UUID.randomUUID().toString());
	}
	
	public void simulandoGauge() {
	    double randomNumber = random.nextInt();
	    if (randomNumber % 2 == 0) {
	        addString();
	    } 
	}

}
