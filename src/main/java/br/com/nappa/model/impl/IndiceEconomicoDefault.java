package br.com.nappa.model.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.nappa.model.IndiceEconomico;

public class IndiceEconomicoDefault implements IndiceEconomico{
	
	private LocalDate date;
	private BigDecimal taxaAoAno;
	private BigDecimal fatorDiario;

	public IndiceEconomicoDefault(LocalDate date, BigDecimal fatorDiario) {
		super();
		this.date = date;		
		this.fatorDiario = fatorDiario;
	}
	
	public IndiceEconomicoDefault(String date, BigDecimal fatorDiario) {		
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
