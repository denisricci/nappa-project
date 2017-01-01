package br.com.nappa.data.impl;

import java.math.BigDecimal;

import br.com.nappa.data.CommaSeparatedValuesAdapter;
import br.com.nappa.model.Selic;

public class CsvSelicAdapter implements CommaSeparatedValuesAdapter<Selic>{
	
	
	private final static String SELIC_CSV_PATH = "selic.csv";
	
	@Override
	public Selic build(String[] values) {		
		String data = values[0];
		BigDecimal taxaAoAno = new BigDecimal(values[1].replaceAll(",", "."));
		BigDecimal fatorDiario = new BigDecimal(values[2].replaceAll(",", "."));		
		return new Selic(data, taxaAoAno, fatorDiario);
	}

	@Override
	public String getFilePath() {
		return SELIC_CSV_PATH;
	}

}
