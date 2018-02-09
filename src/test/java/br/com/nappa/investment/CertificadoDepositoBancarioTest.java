package br.com.nappa.investment;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.investment.impl.CertificadoDepositoBancario;
import br.com.nappa.calculator.impl.RetroactiveInvestmentCalculator;
import br.com.nappa.model.ProfitabilityDetails;
import org.junit.Assert;
import org.junit.Test;

import br.com.nappa.calculator.InvestmentCalculator;

public class CertificadoDepositoBancarioTest {

	@Test
	public void deveCalcularCorretamenteValorBrutoDoCDB() throws Exception{
		CertificadoDepositoBancario cdb = new CertificadoDepositoBancario(new BigDecimal(50000),
				LocalDate.of(2015, 7, 13), LocalDate.of(2017, 1, 1), new BigDecimal(0.95d));
		InvestmentCalculator calculadora = new RetroactiveInvestmentCalculator();
		ProfitabilityDetails detalhesInvestimento = calculadora.calculate(cdb);
		Assert.assertEquals(60104.82d, detalhesInvestimento.getValorBruto().doubleValue(), 0.01d);
	}
	
	@Test
	public void deveCalcularCorretamenteOsDetalhesDoCDB() throws Exception{
		CertificadoDepositoBancario cdb = new CertificadoDepositoBancario(new BigDecimal(50000),
				LocalDate.of(2015, 7, 13), LocalDate.of(2017, 2, 15), new BigDecimal(0.95d));
		InvestmentCalculator calculadora = new RetroactiveInvestmentCalculator();
		ProfitabilityDetails detalhesInvestimento = calculadora.calculate(cdb);
		Assert.assertEquals(61029.79d, detalhesInvestimento.getValorBruto().doubleValue(), 0.01d);
		Assert.assertEquals(59099.58d, detalhesInvestimento.getValorLiquido().doubleValue(), 0.01d);
		double diferenca = detalhesInvestimento.getValorBruto().subtract(detalhesInvestimento.getValorLiquido()).doubleValue();
		Assert.assertEquals(diferenca, detalhesInvestimento.getImpostoDeRenda().doubleValue(), 0.01d);
	}
	

}
