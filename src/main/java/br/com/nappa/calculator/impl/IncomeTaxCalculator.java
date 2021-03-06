package br.com.nappa.calculator.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IncomeTaxCalculator {


	public static BigDecimal calculateTax(LocalDate dtInicio, LocalDate dtFim, BigDecimal valor) {
		long dias = dtFim.toEpochDay() - dtInicio.toEpochDay();

		if (dias <= 180) {
			return valor.multiply(new BigDecimal(0.225));
		}

		if (dias <= 360) {
			return valor.multiply(new BigDecimal(0.20));
		}

		if (dias <= 720) {
			return valor.multiply(new BigDecimal(0.175));
		}

		return valor.multiply(new BigDecimal(0.15));
	}
}
