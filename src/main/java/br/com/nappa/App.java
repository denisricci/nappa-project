package br.com.nappa;

import br.com.nappa.calculator.InvestmentCalculator;
import br.com.nappa.calculator.impl.RetroactiveInvestmentCalculator;
import br.com.nappa.investment.impl.CertificadoDepositoBancario;
import br.com.nappa.model.ProfitabilityDetails;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws Exception {

		CertificadoDepositoBancario cdb = new CertificadoDepositoBancario(new BigDecimal(5000),
						LocalDate.of(2017,02,20), LocalDate.now().minusDays(1), new BigDecimal(1.175d));
		InvestmentCalculator calculadora = new RetroactiveInvestmentCalculator();
		ProfitabilityDetails detalhes = calculadora.calculate(cdb);
		System.out.println("IR:" + detalhes.getImpostoDeRenda());
		System.out.println("Bruto:" + detalhes.getValorBruto());
		System.out.println("Liquido:" +  detalhes.getValorLiquido());
		
//		EconomicIndexHistory selicHistory = new EconomicIndexHistoryBCB(LocalDate.of(2015, 7, 13), LocalDate.now());
//		Investment tesouroSelic = new TesouroSelic(new BigDecimal(19963.72), LocalDate.of(2016, 2, 18),
//				LocalDate.now(), new BigDecimal(0.001));	
//		System.out.println(calculadora.calculate(tesouroSelic, selicHistory));

	}
}
