package br.com.nappa.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IndiceEconomico {
	
	LocalDate getDate();
	BigDecimal getFatorDiario();
	
}
