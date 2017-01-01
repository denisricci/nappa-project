package br.com.nappa.logic.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.enums.IndiceEconomicoEnum;
import br.com.nappa.logic.Investimento;
import br.com.nappa.utils.CalculadoraUtils;

public class CertificadoDepositoBancario extends Investimento {

	private final BigDecimal porcentagemCDI;

	public CertificadoDepositoBancario(BigDecimal valor, LocalDate dataInicial, LocalDate dataFinal,
			BigDecimal porcentagemCDI) {
		super(valor, dataInicial, dataFinal);
		this.porcentagemCDI = porcentagemCDI;
	}

	@Override
	public BigDecimal calculoDiario(BigDecimal currentAmount, BigDecimal fatorDiario) {		
		return currentAmount.multiply(CalculadoraUtils.porcentagemDo(fatorDiario, porcentagemCDI));
	}

	@Override
	public IndiceEconomicoEnum getIndiceEconomico() {
		return IndiceEconomicoEnum.CDI;
	}		

}
