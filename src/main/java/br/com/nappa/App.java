package br.com.nappa;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import br.com.nappa.logic.CertificadoDepositoBancario;
import br.com.nappa.model.Selic;
import br.com.nappa.utils.SelicUtils;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		LocalDate currentDate = LocalDate.of(2015, 7, 13);
		LocalDate today = LocalDate.now();
		BigDecimal amount = new BigDecimal(50000);
		CertificadoDepositoBancario cdb = new CertificadoDepositoBancario(new BigDecimal(0.95d));
		do {
			currentDate = currentDate.plusDays(1);
			Optional<Selic> selic = SelicUtils.getSelic(currentDate);
			if (selic.isPresent()) {
				amount = cdb.calculoDiario(amount, selic.get().getFatorDiario());
			}
			currentDate = currentDate.plusDays(1);
		} while ((!currentDate.isEqual(today)));
		System.out.println(String.format("%.8f", amount));
	}
}
