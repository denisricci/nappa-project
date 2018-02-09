package br.com.nappa.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface EconomicIndex {
	
	LocalDate getDate();
	BigDecimal getFatorDiario();
	
}
