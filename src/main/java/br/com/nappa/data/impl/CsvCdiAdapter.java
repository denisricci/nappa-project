package br.com.nappa.data.impl;

import java.math.BigDecimal;

import br.com.nappa.data.CommaSeparatedValuesAdapter;
import br.com.nappa.model.CDI;

public class CsvCdiAdapter implements CommaSeparatedValuesAdapter<CDI> {

	@Override
	public CDI build(String[] values) {
		BigDecimal taxaAoAno = new BigDecimal(values[4].replaceAll(",", "."));
		BigDecimal taxaAoDia = new BigDecimal(values[3].replaceAll(",", "."));
		return new CDI(values[0], taxaAoDia, taxaAoAno);
	}

	@Override
	public String getFilePath() {
		return "cdi.csv";
	}

}
