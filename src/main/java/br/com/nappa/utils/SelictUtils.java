package br.com.nappa.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.nappa.logic.Selic;

public class SelictUtils {

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

	private static void buildSelic(String [] values) {				
		String dataInicial = values[3].substring(0, 10);
		String dataFinal = null;
		BigDecimal taxa = new BigDecimal(values[4].replaceAll(",", "."));		
		if(values[3].length() > 13)
		dataFinal = values[3].substring(13);		
		selicHistory.add(new Selic(dataInicial, dataFinal, taxa));
	}
	
	public static List<Selic> getHistory(){
		return selicHistory;
	}
	
	public static BigDecimal getTaxaDoDia(LocalDate date){
		for (Selic selic : getHistory()){
			if (selic.getInicio().isBefore(date) && (selic.getFim() == null ||selic.getFim().isAfter(date))){
				return selic.getTaxa();
			}
		}		
		return BigDecimal.ONE;
	}
	
	
}
