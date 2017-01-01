package br.com.nappa.enums;

import br.com.nappa.data.CommaSeparatedValuesAdapter;
import br.com.nappa.data.impl.CsvCdiAdapter;
import br.com.nappa.data.impl.CsvSelicAdapter;

public enum IndiceEconomicoEnum {
	SELIC(new CsvSelicAdapter()),
	CDI(new CsvCdiAdapter());
	
	
	private CommaSeparatedValuesAdapter<?> adapter;
	
	public CommaSeparatedValuesAdapter<?> getAdapter() {
		return adapter;
	}

	private IndiceEconomicoEnum(CommaSeparatedValuesAdapter<?> adapter) {	
		this.adapter=adapter;
	}
			
}
