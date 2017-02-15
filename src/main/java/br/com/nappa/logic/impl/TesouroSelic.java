package br.com.nappa.logic.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.enums.TipoIndiceEconomicoEnum;
import br.com.nappa.logic.Investimento;
import br.com.nappa.model.DetatalhesRendimento;
import br.com.nappa.utils.ImpostoDeRendaUtils;

public class TesouroSelic extends Investimento {

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
	public TipoIndiceEconomicoEnum getIndiceEconomico() {
		return TipoIndiceEconomicoEnum.SELIC;
	}

	@Override
	public DetatalhesRendimento detalhesRendimento() {
		BigDecimal IR = ImpostoDeRendaUtils.calcularImposto(getDataInicial(), getDataFinal(),
				currentAmount.subtract(getValorInicial()));
		return new DetatalhesRendimento(currentAmount.subtract(IR), currentAmount, IR);
	}

}
