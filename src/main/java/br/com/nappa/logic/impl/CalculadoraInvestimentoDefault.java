package br.com.nappa.logic.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.logic.CalculadoraInvestimento;
import br.com.nappa.logic.IndiceEconomicoHistory;
import br.com.nappa.logic.Investimento;
import br.com.nappa.model.IndiceEconomico;

public class CalculadoraInvestimentoDefault implements CalculadoraInvestimento {

	@Override
	public BigDecimal calculaInvestimento(Investimento investimento) {
		IndiceEconomicoHistory history = new IndiceEconomicoHistoryDefault();
		
		int cont = 0;
		LocalDate currentDate = investimento.getDataInicial();
		BigDecimal valor = investimento.getValor();
		do {			
			Optional<IndiceEconomico> indiceEconomico = history.getIndicePorData(currentDate, investimento.getIndiceEconomico());						
			if (indiceEconomico.isPresent()) {
//				System.out.println(indiceEconomico.get().getDate() + "(" + indiceEconomico.get().getDate().getDayOfWeek() +")" + " " + indiceEconomico.get().getFatorDiario());
				valor = investimento.calculoDiario(valor, indiceEconomico.get().getFatorDiario());
//				cont++;
			}
			currentDate = currentDate.plusDays(1);
		} while ((!currentDate.isAfter(investimento.getDataFinal())));
//		System.out.println(cont);
		return valor;
	}
}
