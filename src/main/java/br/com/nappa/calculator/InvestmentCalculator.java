package br.com.nappa.calculator;

import br.com.nappa.investment.Investment;
import br.com.nappa.indexes.EconomicIndexHistory;
import br.com.nappa.model.DetatalhesRendimento;

public interface InvestmentCalculator {
	
	DetatalhesRendimento calculaInvestimento(Investment investment, EconomicIndexHistory economicIndexHistory) throws Exception;
	
}
