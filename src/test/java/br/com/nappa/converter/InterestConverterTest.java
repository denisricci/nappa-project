package br.com.nappa.converter;

import org.junit.Assert;
import org.junit.Test;

public class InterestConverterTest {
	
	@Test
	public void shouldConvertToMonthlyTax(){
		Assert.assertEquals(0.9488d, InterestConverter.yearlyToMonthly(12), 0.0001d);
	}
	
	@Test
	public void shouldConvertToYearlyTax(){
		Assert.assertEquals(20d, InterestConverter.monthlyToYearly(1.5310d), 0.001d);
	}

	@Test
	public void shouldConvertToDailyTax(){
		Assert.assertEquals(1.00050788d, InterestConverter.yearlyToDaily(13.65d), 0.00000001d);
	}
	
}
