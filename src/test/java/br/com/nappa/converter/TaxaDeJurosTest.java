package br.com.nappa.converter;

import org.junit.Assert;
import org.junit.Test;

public class TaxaDeJurosTest {
	
	@Test
	public void deveConverterTaxaAnualParaMensal(){
		Assert.assertEquals(0.9488d, TaxaDeJuros.paraMensal(12), 0.0001d);
	}
	
	@Test
	public void deveConverterTaxaMensalParaAnual(){
		Assert.assertEquals(20d, TaxaDeJuros.paraAnual(1.5310d), 0.001d);
	}
	
}
