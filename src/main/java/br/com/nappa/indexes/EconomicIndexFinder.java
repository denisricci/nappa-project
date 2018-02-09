package br.com.nappa.indexes;

import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.model.IndiceEconomico;

public interface EconomicIndexFinder<E extends IndiceEconomico> {
	
	Optional<E> getIndicePorData(LocalDate date);

}
