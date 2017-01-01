package br.com.nappa;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.logic.CalculadoraInvestimento;
import br.com.nappa.logic.Investimento;
import br.com.nappa.logic.impl.CalculadoraInvestimentoDefault;
import br.com.nappa.logic.impl.CertificadoDepositoBancario;
import br.com.nappa.logic.impl.TesouroSelic;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		CertificadoDepositoBancario cdb = new CertificadoDepositoBancario(new BigDecimal(50000),
				LocalDate.of(2015, 7, 13), LocalDate.now(), new BigDecimal(0.95d));
		CalculadoraInvestimento calculadora = new CalculadoraInvestimentoDefault();
		System.out.println(calculadora.calculaInvestimento(cdb));

		Investimento tesouroSelic = new TesouroSelic(new BigDecimal(19963.72), LocalDate.of(2016, 2, 18),
				LocalDate.now(), new BigDecimal(0.001));	
		System.out.println(calculadora.calculaInvestimento(tesouroSelic));

	}
}
