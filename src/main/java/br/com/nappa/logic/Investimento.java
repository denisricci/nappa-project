package br.com.nappa.logic;

import java.math.BigDecimal;

public interface Investimento {	
		
	BigDecimal calculoDiario(BigDecimal currentAmount, BigDecimal fatorDiario);
	
}
