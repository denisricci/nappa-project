package br.com.nappa.data;

public interface CommaSeparatedValuesAdapter<E> {

	public E build(String[] values);
	public String getFilePath();
}
