package br.com.nappa.logic.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.nappa.enums.TipoIndiceEconomicoEnum;
import br.com.nappa.logic.Investimento;
import br.com.nappa.model.DetatalhesRendimento;
import br.com.nappa.utils.CalculadoraUtils;
import br.com.nappa.utils.ImpostoDeRendaUtils;

public class CertificadoDepositoBancario extends Investimento {

	private final BigDecimal porcentagemCDI;

	public CertificadoDepositoBancario(BigDecimal valor, LocalDate dataInicial, LocalDate dataFinal,
			BigDecimal porcentagemCDI) {
		super(valor, dataInicial, dataFinal);
		this.porcentagemCDI = porcentagemCDI;
	}

	@Override
	public void calculoDiario(BigDecimal fatorDiario) {		
		this.currentAmount = currentAmount.multiply(CalculadoraUtils.porcentagemDo(fatorDiario, porcentagemCDI));
	}

	@Override
	public TipoIndiceEconomicoEnum getIndiceEconomico() {
		return TipoIndiceEconomicoEnum.CDI;
	}

	@Override
	public DetatalhesRendimento detalhesRendimento() {
		return new DetatalhesRendimento(valorLiquido, currentAmount, ImpostoDeRendaUtils.calcularImposto(getDataInicial(), getDataFinal(), currentAmount));
	}
}
