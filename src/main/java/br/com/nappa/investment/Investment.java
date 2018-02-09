package br.com.nappa.investment;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nappa.indexes.EconimicIndex;
import br.com.nappa.model.DetatalhesRendimento;

public abstract class Investment {

	private BigDecimal valorInicial;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	protected BigDecimal currentAmount;
	
	public Investment(BigDecimal valorInicial, LocalDate dataInicial, LocalDate dataFinal) {
		super();
		currentAmount=valorInicial;
		this.valorInicial = valorInicial;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}		

	public abstract void calculoDiario(BigDecimal fatorDiario);
	public abstract EconimicIndex getIndiceEconomico();
	public abstract DetatalhesRendimento detalhesRendimento();
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public BigDecimal getValorInicial() {
		return valorInicial;
	}
}
