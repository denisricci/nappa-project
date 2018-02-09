package br.com.nappa.calculator.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.com.nappa.calculator.InvestmentCalculator;
import br.com.nappa.exceptios.RetroactiveDateOutOfRangeException;
import br.com.nappa.indexes.EconomicIndexHistory;
import br.com.nappa.indexes.impl.EconomicIndexHistoryBCB;
import br.com.nappa.investment.Investment;
import br.com.nappa.model.ProfitabilityDetails;
import br.com.nappa.model.EconomicIndex;

public class RetroactiveInvestmentCalculator implements InvestmentCalculator {

  @Override
  public ProfitabilityDetails calculate(Investment investment) throws Exception {
    validateDates(investment);

    LocalDate currentDate = investment.getDataInicial();
    EconomicIndexHistory economicIndexHistory = new EconomicIndexHistoryBCB();
    List<EconomicIndex> indexes = economicIndexHistory.getIndexHistory(investment.getIndiceEconomico(), investment.getDataInicial(), investment.getDataFinal());

    for (EconomicIndex index : indexes) {
      investment.calculoDiario(index.getFatorDiario());
    }

    return investment.detalhesRendimento();
  }

  private void validateDates(Investment investment) {
    LocalDate today = LocalDate.now();
    if (investment.getDataInicial().isAfter(today) || investment.getDataFinal().isAfter(today)) {
      throw new RetroactiveDateOutOfRangeException();
    }
  }
}