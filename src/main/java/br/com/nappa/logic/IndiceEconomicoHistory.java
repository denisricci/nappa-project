package br.com.nappa.logic;

import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.enums.IndiceEconomicoEnum;
import br.com.nappa.model.IndiceEconomico;

public interface IndiceEconomicoHistory {
		
	public Optional<IndiceEconomico> getIndicePorData(LocalDate date, IndiceEconomicoEnum indiceEconomicoEnum);		
	
}
