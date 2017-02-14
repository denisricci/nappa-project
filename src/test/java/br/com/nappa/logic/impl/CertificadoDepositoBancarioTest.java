package br.com.nappa.logic.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.com.nappa.logic.CalculadoraInvestimento;
import br.com.nappa.logic.IndiceEconomicoHistory;
import br.com.nappa.logic.impl.CalculadoraInvestimentoDefault;
import br.com.nappa.logic.impl.CertificadoDepositoBancario;
import br.com.nappa.logic.impl.IndiceEconomicoHistoryBCB;
import br.com.nappa.model.DetatalhesRendimento;

public class CertificadoDepositoBancarioTest {
	
	@Test
	public void deveCalcularCorretamenteValorDoCDB() throws Exception{
		
		IndiceEconomicoHistory CdiHistory = new IndiceEconomicoHistoryBCB(LocalDate.of(2015, 7, 13), LocalDate.of(2017, 1, 1));
		
		CertificadoDepositoBancario cdb = new CertificadoDepositoBancario(new BigDecimal(50000),
				LocalDate.of(2015, 7, 13), LocalDate.of(2017, 1, 1), new BigDecimal(0.95d));
		CalculadoraInvestimento calculadora = new CalculadoraInvestimentoDefault();
		DetatalhesRendimento detalhesInvestimento = calculadora.calculaInvestimento(cdb, CdiHistory);		
		Assert.assertEquals(60104.82d, detalhesInvestimento.getValorBruto().doubleValue(), 0.01d);
	}

}
