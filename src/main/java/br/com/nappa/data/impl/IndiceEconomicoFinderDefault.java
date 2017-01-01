package br.com.nappa.data.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.com.nappa.data.IndiceEconomicoFinder;
import br.com.nappa.model.IndiceEconomico;

public class IndiceEconomicoFinderDefault<E extends IndiceEconomico> implements IndiceEconomicoFinder<E> {

	private List<E> indices;

	public IndiceEconomicoFinderDefault(List<E> indices) {
		this.indices = indices;
	}

	@Override
	public Optional<E> getIndicePorData(LocalDate date) {
		return indices.stream().filter(t -> t.getDate().isEqual(date)).findFirst();		
	}

}
