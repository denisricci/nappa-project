package br.com.nappa.indexes;

import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.model.IndiceEconomico;

public interface EconomicIndexHistory {
		
	public Optional<IndiceEconomico> getIndicePorData(LocalDate date);	
	public void loadIndice(EconimicIndex indice) throws Exception;
	
}
