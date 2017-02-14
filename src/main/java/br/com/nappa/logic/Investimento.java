package br.com.nappa.logic;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.enums.TipoIndiceEconomicoEnum;

public abstract class Investimento {

	private BigDecimal valor;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	
	public Investimento(BigDecimal valor, LocalDate dataInicial, LocalDate dataFinal) {
		super();
		this.valor = valor;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}		

	public abstract BigDecimal calculoDiario(BigDecimal currentAmount, BigDecimal fatorDiario);

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}
	
	public abstract TipoIndiceEconomicoEnum getIndiceEconomico();
}
