package br.com.nappa.data;

import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.model.IndiceEconomico;

public interface IndiceEconomicoFinder<E extends IndiceEconomico> {
	
	Optional<E> getIndicePorData(LocalDate date);

}
