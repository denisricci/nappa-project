package br.com.nappa.logic.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.enums.IndiceEconomicoEnum;
import br.com.nappa.logic.Investimento;

public class TesouroSelic extends Investimento{
	
	private BigDecimal taxaDaAdministradora;

	public TesouroSelic(BigDecimal valor, LocalDate dataInicial, LocalDate dataFinal, BigDecimal taxaDaAdministradora) {
		super(valor.subtract(valor.multiply(taxaDaAdministradora)), dataInicial, dataFinal);
		this.taxaDaAdministradora=taxaDaAdministradora;
	}

	@Override
	public BigDecimal calculoDiario(BigDecimal currentAmount, BigDecimal fatorDiario) {
		return currentAmount.multiply(fatorDiario);
	}

	@Override
	public IndiceEconomicoEnum getIndiceEconomico() {
		return IndiceEconomicoEnum.SELIC;
	}

}
