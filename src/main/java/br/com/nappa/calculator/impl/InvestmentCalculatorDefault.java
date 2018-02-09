package br.com.nappa.calculator.impl;

import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.calculator.InvestmentCalculator;
import br.com.nappa.indexes.EconomicIndexHistory;
import br.com.nappa.investment.Investment;
import br.com.nappa.model.DetatalhesRendimento;
import br.com.nappa.model.IndiceEconomico;

public class InvestmentCalculatorDefault implements InvestmentCalculator {

	@Override
	public DetatalhesRendimento calculaInvestimento(Investment investment,
			EconomicIndexHistory economicIndexHistory) throws Exception {
		LocalDate currentDate = investment.getDataInicial();
		economicIndexHistory.loadIndice(investment.getIndiceEconomico());
		do {
			Optional<IndiceEconomico> indiceEconomico = economicIndexHistory.getIndicePorData(currentDate);
			if (indiceEconomico.isPresent()) {
				investment.calculoDiario(indiceEconomico.get().getFatorDiario());
			}
			currentDate = currentDate.plusDays(1);
		} while ((!currentDate.isAfter(investment.getDataFinal())));
		return investment.detalhesRendimento();
	}
}