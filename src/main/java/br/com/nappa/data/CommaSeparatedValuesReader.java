package br.com.nappa.data;

import java.util.List;

public interface CommaSeparatedValuesReader {

	public <E> List<E> read(CommaSeparatedValuesAdapter<E> adapter);
	
}
