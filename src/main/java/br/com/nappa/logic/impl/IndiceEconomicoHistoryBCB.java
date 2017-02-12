package br.com.nappa.logic.impl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.nappa.data.IndiceEconomicoFinder;
import br.com.nappa.data.impl.IndiceEconomicoFinderDefault;
import br.com.nappa.enums.TipoIndiceEconomicoEnum;
import br.com.nappa.logic.IndiceEconomicoHistory;
import br.com.nappa.model.IndiceEconomico;
import br.com.nappa.model.impl.IndiceEconomicoDefault;
import br.gov.bcb.pec.sgs.casosdeuso.ws.comum.WSSerieVO;
import br.gov.bcb.pec.sgs.casosdeuso.ws.comum.WSValorSerieVO;
import br.gov.bcb.www3.wssgs.services.FachadaWSSGS.FachadaWSSGSProxy;

public class IndiceEconomicoHistoryBCB implements IndiceEconomicoHistory {

	private LocalDate dtInicio;
	private LocalDate dtFim;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	Map<TipoIndiceEconomicoEnum, Long> series = new HashMap<>();

	{
		series.put(TipoIndiceEconomicoEnum.SELIC, 11l);
		series.put(TipoIndiceEconomicoEnum.CDI, 12l);

	}

	List<IndiceEconomico> indices = new ArrayList<>();

	public IndiceEconomicoHistoryBCB(LocalDate dtInicio, LocalDate dtFim) {
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
	}

	@Override
	public Optional<IndiceEconomico> getIndicePorData(LocalDate date) {
		IndiceEconomicoFinder<IndiceEconomico> finder = new IndiceEconomicoFinderDefault<IndiceEconomico>(indices);
		return finder.getIndicePorData(date);
	}

	public void loadIndice(TipoIndiceEconomicoEnum indice) throws RemoteException {
		WSSerieVO[] valoresSeriesVO = new FachadaWSSGSProxy().getFachadaWSSGS().getValoresSeriesVO(
				new long[] { series.get(indice) }, dtInicio.format(formatter), dtFim.format(formatter));
		for (WSSerieVO valor : valoresSeriesVO) {
			for (WSValorSerieVO valorSerie : valor.getValores()) {
				LocalDate date = LocalDate.of(valorSerie.getAno(), valorSerie.getMes(), valorSerie.getDia());
				BigDecimal fatorDiario = new BigDecimal(valorSerie.getSvalor()).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE);
				IndiceEconomico indiceEconomico = new IndiceEconomicoDefault(date, fatorDiario);
				indices.add(indiceEconomico);
			}
		}
	}
}
