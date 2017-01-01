package br.com.nappa.data.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import br.com.nappa.data.CommaSeparatedValuesAdapter;
import br.com.nappa.data.CommaSeparatedValuesReader;

public class CommaSeparatedValuesReaderDefault implements CommaSeparatedValuesReader {

	@Override
	public <E> List<E> read(CommaSeparatedValuesAdapter<E> adapter) {

		List<E> list = new ArrayList<>();
		BufferedReader br = null;
		String linha = "";

		try {
			br = new BufferedReader(new FileReader(adapter.getFilePath()));
			while ((linha = br.readLine()) != null) {
				list.add(adapter.build(linha.split(";")));
			}
			br.close();
		} catch (Exception e) {
			// TODO tratar melhor esse erro e utilizar log4j
			e.printStackTrace();
		}

		return list;
	}

}
