package br.com.nappa.logic;

import java.math.BigDecimal;

import br.com.nappa.enums.Periodo;

public interface Investimento {
	
	public BigDecimal multiplicadorDiario(BigDecimal valor);
	public BigDecimal multiplicadorMensal(BigDecimal valor);
	public BigDecimal multiplicadorAnual(BigDecimal valor);
	public BigDecimal getTaxaAdministrativa(Periodo periodo);
	public BigDecimal getImposto(int quantidadeDePeriodos, Periodo periodo);
	
}
