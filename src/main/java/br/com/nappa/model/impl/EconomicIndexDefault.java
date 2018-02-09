package br.com.nappa.model.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.nappa.model.EconomicIndex;

public class EconomicIndexDefault implements EconomicIndex {
	
	private LocalDate date;
	private BigDecimal taxaAoAno;
	private BigDecimal fatorDiario;

	public EconomicIndexDefault(LocalDate date, BigDecimal fatorDiario) {
		super();
		this.date = date;		
		this.fatorDiario = fatorDiario;
	}
	
	public EconomicIndexDefault(String date, BigDecimal fatorDiario) {
		this(LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy")), fatorDiario);		
	}

	public LocalDate getDate() {
		return date;
	}

	public BigDecimal getTaxaAoAno() {
		return taxaAoAno;
	}

	public BigDecimal getFatorDiario() {
		return fatorDiario;
	}
}
