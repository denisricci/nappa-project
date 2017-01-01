package br.com.nappa.logic;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.com.nappa.logic.impl.CalculadoraInvestimentoDefault;
import br.com.nappa.logic.impl.CertificadoDepositoBancario;

public class CertificadoDepositoBancarioTest {
	
	@Test
	public void deveCalcularCorretamenteValorDoCDB(){
		CertificadoDepositoBancario cdb = new CertificadoDepositoBancario(new BigDecimal(50000),
				LocalDate.of(2015, 7, 13), LocalDate.of(2017, 1, 1), new BigDecimal(0.95d));
		CalculadoraInvestimento calculadora = new CalculadoraInvestimentoDefault();
		BigDecimal valorFinal = calculadora.calculaInvestimento(cdb);		
		Assert.assertEquals(60104.82d, valorFinal.doubleValue(), 0.01d);
	}

}
