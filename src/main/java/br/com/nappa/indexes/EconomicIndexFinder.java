package br.com.nappa.indexes;

import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.model.EconomicIndex;

public interface EconomicIndexFinder<E extends EconomicIndex> {
	
	Optional<E> getIndicePorData(LocalDate date);

}
