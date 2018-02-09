package br.com.nappa.calculator;

import br.com.nappa.investment.Investment;
import br.com.nappa.model.ProfitabilityDetails;

public interface InvestmentCalculator {
	
	ProfitabilityDetails calculate(Investment investment) throws Exception;
	
}
