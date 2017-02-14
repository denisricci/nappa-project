package br.com.nappa.logic.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraDeImpostoDeRendaTest {

	@Test
	public void validaRegraDoImpostoDeRenta() {
		CalculadoraDeImpostoDeRenda calculadoraDeImposto = new CalculadoraDeImpostoDeRenda();
		BigDecimal imposto = calculadoraDeImposto.calcularImpostoDeRenda(LocalDate.of(2014, 1, 1),
				LocalDate.of(2014, 1, 31), new BigDecimal(100000));
		Assert.assertEquals(22500d, imposto.doubleValue(), 0.01d);
		imposto = calculadoraDeImposto.calcularImpostoDeRenda(LocalDate.of(2014, 1, 1),
				LocalDate.of(2014, 7, 31), new BigDecimal(100000));
		Assert.assertEquals(20000d, imposto.doubleValue(), 0.01d);
		imposto = calculadoraDeImposto.calcularImpostoDeRenda(LocalDate.of(2014, 1, 1),
				LocalDate.of(2015, 1, 1), new BigDecimal(100000));
		Assert.assertEquals(17500, imposto.doubleValue(), 0.01d);
		imposto = calculadoraDeImposto.calcularImpostoDeRenda(LocalDate.of(2014, 1, 1),
				LocalDate.of(2016, 1, 1), new BigDecimal(100000));
		Assert.assertEquals(15000, imposto.doubleValue(), 0.01d);
	}

}
