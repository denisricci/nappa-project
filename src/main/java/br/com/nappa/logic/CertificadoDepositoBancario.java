package br.com.nappa.logic;

import java.math.BigDecimal;

import br.com.nappa.utils.CalculadoraUtils;

public class CertificadoDepositoBancario implements Investimento {

	private final BigDecimal porcentagemCDI;

	public CertificadoDepositoBancario(BigDecimal porcentagemCDI) {
		super();
		this.porcentagemCDI = porcentagemCDI;
	}

	@Override
	public BigDecimal calculoDiario(BigDecimal currentAmount, BigDecimal fatorDiario) {
		currentAmount=currentAmount.multiply(CalculadoraUtils.porcentagemDo(fatorDiario, porcentagemCDI));
		return currentAmount;
	}

}
