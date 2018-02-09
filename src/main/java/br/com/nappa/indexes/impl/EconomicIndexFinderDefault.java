package br.com.nappa.indexes.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.com.nappa.indexes.EconomicIndexFinder;
import br.com.nappa.model.EconomicIndex;

public class EconomicIndexFinderDefault<E extends EconomicIndex> implements EconomicIndexFinder<E> {

	private List<E> indices;

	public EconomicIndexFinderDefault(List<E> indices) {
		this.indices = indices;
	}

	@Override
	public Optional<E> getIndicePorData(LocalDate date) {
		return indices.stream().filter(t -> t.getDate().isEqual(date)).findFirst();		
	}

}
