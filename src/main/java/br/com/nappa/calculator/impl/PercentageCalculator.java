package br.com.nappa.calculator.impl;

import java.math.BigDecimal;

public class PercentageCalculator {

	public static BigDecimal lessThanZeroPercentage(BigDecimal value, BigDecimal percentage) {
		BigDecimal result = value.subtract(BigDecimal.ONE);			
		return result.multiply(percentage).add(BigDecimal.ONE);
	}
}
