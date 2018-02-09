package br.com.nappa.calculator.impl;

import br.com.nappa.calculator.InvestmentCalculator;
import br.com.nappa.exceptios.RetroactiveDateOutOfRangeException;
import br.com.nappa.indexes.EconomicIndexHistory;
import br.com.nappa.indexes.impl.EconomicIndexHistoryBCB;
import br.com.nappa.investment.Investment;
import br.com.nappa.model.EconomicIndex;
import br.com.nappa.model.ProfitabilityDetails;

import java.time.LocalDate;
import java.util.List;

public class PredictionInvestimentCalculator implements InvestmentCalculator{


  @Override
  public ProfitabilityDetails calculate(Investment investment) throws Exception {
    validateDates(investment);
    EconomicIndexHistory economicIndexHistory = new EconomicIndexHistoryBCB();
    EconomicIndex index = economicIndexHistory.getIndexHistory(investment.getIndiceEconomico(), LocalDate.now(), LocalDate.now()).get(0);
    LocalDate currentDate = investment.getDataInicial();
    do{


    }while (currentDate.isBefore(investment.getDataFinal()));

    return null;
  }

  private void validateDates(Investment investment){
    LocalDate today = LocalDate.now();
    if (investment.getDataInicial().isBefore(today) || investment.getDataFinal().isBefore(today)) {
      throw new RetroactiveDateOutOfRangeException();
    }
  }
}
