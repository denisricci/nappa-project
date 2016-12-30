package br.com.nappa.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.nappa.model.Selic;

public class SelicUtils {

	private static List<Selic> selicHistory = new ArrayList<>();

	static {
		BufferedReader br = null;
		String linha = "";

		try {
			br = new BufferedReader(new FileReader("selic.csv"));
			while ((linha = br.readLine()) != null) {
				buildSelic(linha.split(";"));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void buildSelic(String[] values) {
		String data = values[0];
		BigDecimal taxaAoAno = new BigDecimal(values[1].replaceAll(",", "."));
		BigDecimal fatorDiario = new BigDecimal(values[2].replaceAll(",", "."));
		selicHistory.add(new Selic(data, taxaAoAno, fatorDiario));
	}

	public static Optional<Selic> getSelic(LocalDate data) {
		return selicHistory.stream().filter(t -> t.getDate().isEqual(data)).findFirst();
	}

}
