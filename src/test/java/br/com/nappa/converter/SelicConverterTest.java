package br.com.nappa.converter;

import org.junit.Assert;
import org.junit.Test;

public class SelicConverterTest {
	
	@Test
	public void deveConverterSelicParaTaxaDiaria(){		
		Assert.assertEquals(1.00050788d, SelicConverter.paraTaxaDiaria(13.65d), 0.00000001d);				
	}
	
}
