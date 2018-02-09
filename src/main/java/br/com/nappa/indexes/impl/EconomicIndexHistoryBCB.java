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
import br.com.nappa.model.IndiceEconomico;
import br.com.nappa.model.impl.IndiceEconomicoDefault;
import br.gov.bcb.pec.sgs.casosdeuso.ws.comum.WSSerieVO;
import br.gov.bcb.pec.sgs.casosdeuso.ws.comum.WSValorSerieVO;
import br.gov.bcb.www3.wssgs.services.FachadaWSSGS.FachadaWSSGSProxy;

public class EconomicIndexHistoryBCB implements EconomicIndexHistory {

	private LocalDate dtInicio = LocalDate.now().minusDays(1);
	private LocalDate dtFim = LocalDate.now().minusDays(1);	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	Map<EconimicIndex, Long> series = new HashMap<>();

	{
		series.put(EconimicIndex.SELIC, 11l);
		series.put(EconimicIndex.CDI, 12l);

	}

	List<IndiceEconomico> indices = new ArrayList<>();

	public EconomicIndexHistoryBCB(LocalDate dtInicio, LocalDate dtFim) {
		if (dtInicio.isBefore(LocalDate.now())) {
			this.dtInicio = dtInicio;
		}

		if (dtFim.isBefore(LocalDate.now())) {
			this.dtFim = dtFim;
		}
	}

	@Override
	public Optional<IndiceEconomico> getIndicePorData(LocalDate date) {
		EconomicIndexFinder<IndiceEconomico> finder = new EconomicIndexFinderDefault<IndiceEconomico>(indices);

		LocalDate today = LocalDate.now();
		if (date.isBefore(today)) {
			return finder.getIndicePorData(date);
		}

		return finder.getIndicePorData(today.minusDays(1));
	}

	public void loadIndice(EconimicIndex indice) throws RemoteException {
		WSSerieVO[] valoresSeriesVO = new FachadaWSSGSProxy().getFachadaWSSGS().getValoresSeriesVO(
				new long[] { series.get(indice) }, dtInicio.format(formatter), dtFim.format(formatter));
		for (WSSerieVO valor : valoresSeriesVO) {
			for (WSValorSerieVO valorSerie : valor.getValores()) {
				LocalDate date = LocalDate.of(valorSerie.getAno(), valorSerie.getMes(), valorSerie.getDia());
				BigDecimal fatorDiario = new BigDecimal(valorSerie.getSvalor()).divide(BigDecimal.valueOf(100))
						.add(BigDecimal.ONE);
				IndiceEconomico indiceEconomico = new IndiceEconomicoDefault(date, fatorDiario);
				indices.add(indiceEconomico);
			}
		}
	}
}
