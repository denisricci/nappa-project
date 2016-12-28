package br.com.nappa.utils;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class SelicUtilsTest {

		
	@Test
	public void deveRetonarValoresCorretosDaSelic(){
		BigDecimal selic1 = SelictUtils.getTaxaDoDia(LocalDate.of(2016, 12, 27));
		BigDecimal selic2 = SelictUtils.getTaxaDoDia(LocalDate.of(2015, 7, 29));	
		BigDecimal selic3 = SelictUtils.getTaxaDoDia(LocalDate.of(2014, 12, 3));
		BigDecimal selic4 = SelictUtils.getTaxaDoDia(LocalDate.of(2013, 5, 29));
		BigDecimal selic5 = SelictUtils.getTaxaDoDia(LocalDate.of(2004, 1, 21));
		BigDecimal selic6 = SelictUtils.getTaxaDoDia(LocalDate.of(1996, 8, 21));
		Assert.assertEquals(new BigDecimal("13.75"), selic1);
		Assert.assertEquals(new BigDecimal("13.75"), selic2);
		Assert.assertEquals(new BigDecimal("11.25"), selic3);
		Assert.assertEquals(new BigDecimal("7.5"), selic4);
		Assert.assertEquals(new BigDecimal("16.5"),selic5);
		Assert.assertEquals(new BigDecimal("1.9"),selic6);
	}
	
}
