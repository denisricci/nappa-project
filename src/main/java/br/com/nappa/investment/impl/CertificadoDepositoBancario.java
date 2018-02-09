package br.com.nappa.investment.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.nappa.indexes.EconimicIndex;
import br.com.nappa.investment.Investment;
import br.com.nappa.model.ProfitabilityDetails;
import br.com.nappa.calculator.impl.PercentageCalculator;
import br.com.nappa.calculator.impl.IncomeTaxCalculator;

public class CertificadoDepositoBancario extends Investment {

	private final BigDecimal porcentagemCDI;

	public CertificadoDepositoBancario(BigDecimal valor, LocalDate dataInicial, LocalDate dataFinal,
			BigDecimal porcentagemCDI) {
		super(valor, dataInicial, dataFinal);
		this.porcentagemCDI = porcentagemCDI;
	}

	@Override
	public void calculoDiario(BigDecimal fatorDiario) {		
		this.currentAmount = currentAmount.multiply(PercentageCalculator.lessThanZeroPercentage(fatorDiario, porcentagemCDI));
	}

	@Override
	public EconimicIndex getIndiceEconomico() {
		return EconimicIndex.CDI;
	}

	@Override
	public ProfitabilityDetails detalhesRendimento() {
		BigDecimal IR = IncomeTaxCalculator.calculateTax(getDataInicial(), getDataFinal(), currentAmount.subtract(getValorInicial()));
		return new ProfitabilityDetails(currentAmount.subtract(IR), currentAmount, IR);
	}
}
