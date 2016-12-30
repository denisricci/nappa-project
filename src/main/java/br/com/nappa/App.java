package br.com.nappa;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.converter.SelicConverter;
import br.com.nappa.model.Selic;
import br.com.nappa.utils.SelicUtils;

/**
 * Hello world!
 *
 */
public class App {
	
	
	public static void main(String[] args) throws IOException {
		LocalDate currentDate = LocalDate.of(2016, 02, 18);
		LocalDate today = LocalDate.now();
		BigDecimal amount = new BigDecimal(50000);
		
		while(!currentDate.isEqual(today)){
			Optional<Selic> selic = SelicUtils.getSelic(currentDate);
			
			if(selic.isPresent()){				
				BigDecimal fatorDiario = selic.get().getFatorDiario().subtract(BigDecimal.ONE);
				fatorDiario = fatorDiario.multiply(new BigDecimal(0.85d)).add(BigDecimal.ONE);				
				amount = amount.multiply(fatorDiario);
				System.out.println(currentDate + "(" + currentDate.getDayOfWeek() +")" + " - " + String.format("%.8f", fatorDiario) + " - " + String.format("%.2f", amount));
			}
			currentDate=currentDate.plusDays(1);
		}
				
	}
}
