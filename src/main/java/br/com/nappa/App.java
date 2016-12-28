package br.com.nappa;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

import br.com.nappa.converter.SelicConverter;
import br.com.nappa.utils.SelictUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		LocalDate currentDate = LocalDate.of(2016, 02, 18);				
		
		LocalDate today = LocalDate.now();

		BigDecimal amount = new BigDecimal(19963.72);

		while (!currentDate.isEqual(today.minusDays(1))) {
			System.out.println(currentDate + " - " + String.format("%.4f", amount));
			if (currentDate.getDayOfWeek() != DayOfWeek.SATURDAY && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {				
				BigDecimal fatorDiario = new BigDecimal(SelicConverter.paraTaxaDiaria(SelictUtils.getTaxaDoDia(currentDate).doubleValue()));
				amount = amount.multiply(fatorDiario);
			}
			currentDate = currentDate.plusDays(1);
		}				
		
		System.out.println(amount.doubleValue());
	}
}
