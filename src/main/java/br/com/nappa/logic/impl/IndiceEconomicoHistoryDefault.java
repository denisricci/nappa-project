package br.com.nappa.logic.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.nappa.data.CommaSeparatedValuesReader;
import br.com.nappa.data.IndiceEconomicoFinder;
import br.com.nappa.data.impl.CommaSeparatedValuesReaderDefault;
import br.com.nappa.data.impl.IndiceEconomicoFinderDefault;
import br.com.nappa.enums.IndiceEconomicoEnum;
import br.com.nappa.logic.IndiceEconomicoHistory;
import br.com.nappa.model.IndiceEconomico;

public class IndiceEconomicoHistoryDefault implements IndiceEconomicoHistory {

	private CommaSeparatedValuesReader reader = new CommaSeparatedValuesReaderDefault();

	private final static Map<String, IndiceEconomicoFinder<IndiceEconomico>> cache = new HashMap<>();

	@Override
	public Optional<IndiceEconomico> getIndicePorData(LocalDate date, IndiceEconomicoEnum indiceEconomicoEnum) {
		if (!cache.containsKey(indiceEconomicoEnum.name())) {
			List<IndiceEconomico> indices = (List<IndiceEconomico>) reader.read(indiceEconomicoEnum.getAdapter());
			cache.put(indiceEconomicoEnum.name(), new IndiceEconomicoFinderDefault<>(indices));
		}
		return cache.get(indiceEconomicoEnum.name()).getIndicePorData(date);
	}

}
