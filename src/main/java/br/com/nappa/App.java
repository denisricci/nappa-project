package br.com.nappa;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.calculator.InvestmentCalculator;
import br.com.nappa.indexes.EconomicIndexHistory;
import br.com.nappa.calculator.impl.InvestmentCalculatorDefault;
import br.com.nappa.investment.impl.CertificadoDepositoBancario;
import br.com.nappa.indexes.impl.EconomicIndexHistoryBCB;
import br.com.nappa.model.DetatalhesRendimento;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws Exception {
		
		EconomicIndexHistory CdiHistory = new EconomicIndexHistoryBCB(LocalDate.of(2017,02,20), LocalDate.now());
		
		CertificadoDepositoBancario cdb = new CertificadoDepositoBancario(new BigDecimal(5000),
						LocalDate.of(2017,02,20), LocalDate.now().minusDays(1), new BigDecimal(1.175d));
		InvestmentCalculator calculadora = new InvestmentCalculatorDefault();
		DetatalhesRendimento detalhes = calculadora.calculaInvestimento(cdb, CdiHistory);
		System.out.println("IR:" + detalhes.getImpostoDeRenda());
		System.out.println("Bruto:" + detalhes.getValorBruto());
		System.out.println("Liquido:" +  detalhes.getValorLiquido());
		
//		EconomicIndexHistory selicHistory = new EconomicIndexHistoryBCB(LocalDate.of(2015, 7, 13), LocalDate.now());
//		Investment tesouroSelic = new TesouroSelic(new BigDecimal(19963.72), LocalDate.of(2016, 2, 18),
//				LocalDate.now(), new BigDecimal(0.001));	
//		System.out.println(calculadora.calculaInvestimento(tesouroSelic, selicHistory));

	}
}
