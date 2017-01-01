package br.com.nappa.utils;

import java.math.BigDecimal;

public class CalculadoraUtils {

	public static BigDecimal porcentagemDo(BigDecimal fatorDiario, BigDecimal porcentagem) {
		BigDecimal result = fatorDiario.subtract(BigDecimal.ONE);			
		return result.multiply(porcentagem).add(BigDecimal.ONE);
	}

}
