package br.com.nappa.logic;

import br.com.nappa.model.DetatalhesRendimento;

public interface CalculadoraInvestimento {
	
	DetatalhesRendimento calculaInvestimento(Investimento investimento, IndiceEconomicoHistory indiceEconomicoHistory) throws Exception;
	
}
