package br.com.nappa;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.logic.CalculadoraInvestimento;
import br.com.nappa.logic.IndiceEconomicoHistory;
import br.com.nappa.logic.impl.CalculadoraInvestimentoDefault;
import br.com.nappa.logic.impl.CertificadoDepositoBancario;
import br.com.nappa.logic.impl.IndiceEconomicoHistoryBCB;
import br.com.nappa.model.DetatalhesRendimento;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws Exception {
		
		IndiceEconomicoHistory CdiHistory = new IndiceEconomicoHistoryBCB(LocalDate.now(), LocalDate.of(2018,12,5));		
		
		CertificadoDepositoBancario cdb = new CertificadoDepositoBancario(new BigDecimal(20000),
				 LocalDate.now(), LocalDate.of(2018,12,5), new BigDecimal(1.18d));
		CalculadoraInvestimento calculadora = new CalculadoraInvestimentoDefault();
		DetatalhesRendimento detalhes = calculadora.calculaInvestimento(cdb, CdiHistory);
		System.out.println("IR:" + detalhes.getImpostoDeRenda());
		System.out.println("Bruto:" + detalhes.getValorBruto());
		System.out.println("Liquido:" +  detalhes.getValorLiquido());
		
//		IndiceEconomicoHistory selicHistory = new IndiceEconomicoHistoryBCB(LocalDate.of(2015, 7, 13), LocalDate.now());
//		Investimento tesouroSelic = new TesouroSelic(new BigDecimal(19963.72), LocalDate.of(2016, 2, 18),
//				LocalDate.now(), new BigDecimal(0.001));	
//		System.out.println(calculadora.calculaInvestimento(tesouroSelic, selicHistory));

	}
}
