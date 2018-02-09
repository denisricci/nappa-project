package br.com.nappa.indexes.impl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.nappa.indexes.EconomicIndexFinder;
import br.com.nappa.indexes.EconimicIndex;
import br.com.nappa.indexes.EconomicIndexHistory;
import br.com.nappa.model.EconomicIndex;
import br.com.nappa.model.impl.EconomicIndexDefault;
import br.gov.bcb.pec.sgs.casosdeuso.ws.comum.WSSerieVO;
import br.gov.bcb.pec.sgs.casosdeuso.ws.comum.WSValorSerieVO;
import br.gov.bcb.www3.wssgs.services.FachadaWSSGS.FachadaWSSGSProxy;

public class EconomicIndexHistoryBCB implements EconomicIndexHistory {

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  Map<EconimicIndex, Long> series = new HashMap<>();

  {
    series.put(EconimicIndex.SELIC, 11l);
    series.put(EconimicIndex.CDI, 12l);

  }

  public List<EconomicIndex> getIndexHistory(EconimicIndex index, LocalDate startDate, LocalDate endDate) throws RemoteException {
    List<EconomicIndex> indices = new ArrayList<>();
    WSSerieVO[] valoresSeriesVO = new FachadaWSSGSProxy().getFachadaWSSGS().getValoresSeriesVO(
            new long[]{series.get(index)}, startDate.format(formatter), endDate.format(formatter));
    for (WSSerieVO valor : valoresSeriesVO) {
      for (WSValorSerieVO valorSerie : valor.getValores()) {
        LocalDate date = LocalDate.of(valorSerie.getAno(), valorSerie.getMes(), valorSerie.getDia());
        BigDecimal fatorDiario = new BigDecimal(valorSerie.getSvalor()).divide(BigDecimal.valueOf(100))
                .add(BigDecimal.ONE);
        EconomicIndex economicIndex = new EconomicIndexDefault(date, fatorDiario);
        indices.add(economicIndex);
      }
    }
    return indices;
  }
}
