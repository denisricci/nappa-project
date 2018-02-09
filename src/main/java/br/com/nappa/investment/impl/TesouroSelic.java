package br.com.nappa.investment.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.indexes.EconimicIndex;
import br.com.nappa.investment.Investment;
import br.com.nappa.model.DetatalhesRendimento;
import br.com.nappa.calculator.impl.IncomeTaxCalculator;

public class TesouroSelic extends Investment {

	private BigDecimal taxaDaAdministradora;

	public TesouroSelic(BigDecimal valor, LocalDate dataInicial, LocalDate dataFinal, BigDecimal taxaDaAdministradora) {
		super(valor.subtract(valor.multiply(taxaDaAdministradora)), dataInicial, dataFinal);
		this.taxaDaAdministradora = taxaDaAdministradora;
	}

	@Override
	public void calculoDiario(BigDecimal fatorDiario) {
		currentAmount = currentAmount.multiply(fatorDiario);
	}

	@Override
	public EconimicIndex getIndiceEconomico() {
		return EconimicIndex.SELIC;
	}

	@Override
	public DetatalhesRendimento detalhesRendimento() {
		BigDecimal IR = IncomeTaxCalculator.calculateTax(getDataInicial(), getDataFinal(),
				currentAmount.subtract(getValorInicial()));
		return new DetatalhesRendimento(currentAmount.subtract(IR), currentAmount, IR);
	}

}
