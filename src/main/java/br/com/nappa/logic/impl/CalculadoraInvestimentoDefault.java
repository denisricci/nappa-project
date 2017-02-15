package br.com.nappa.logic.impl;

import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.logic.CalculadoraInvestimento;
import br.com.nappa.logic.IndiceEconomicoHistory;
import br.com.nappa.logic.Investimento;
import br.com.nappa.model.DetatalhesRendimento;
import br.com.nappa.model.IndiceEconomico;

public class CalculadoraInvestimentoDefault implements CalculadoraInvestimento {

	@Override
	public DetatalhesRendimento calculaInvestimento(Investimento investimento,
			IndiceEconomicoHistory indiceEconomicoHistory) throws Exception {		
		LocalDate currentDate = investimento.getDataInicial();
		indiceEconomicoHistory.loadIndice(investimento.getIndiceEconomico());
		do {
			Optional<IndiceEconomico> indiceEconomico = indiceEconomicoHistory.getIndicePorData(currentDate);
			if (indiceEconomico.isPresent()) {
				investimento.calculoDiario(indiceEconomico.get().getFatorDiario());
			}
			currentDate = currentDate.plusDays(1);
		} while ((!currentDate.isAfter(investimento.getDataFinal())));
		return investimento.detalhesRendimento();
	}
}