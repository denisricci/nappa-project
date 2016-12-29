package br.com.nappa.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Selic {
	
	private LocalDate date;
	private BigDecimal taxaAoAno;
	private BigDecimal fatorDiario;

	public Selic(LocalDate date, BigDecimal taxaAoAno, BigDecimal fatorDiario) {
		super();
		this.date = date;
		this.taxaAoAno = taxaAoAno;
		this.fatorDiario = fatorDiario;
	}
	
	public Selic(String date, BigDecimal taxaAoAno, BigDecimal fatorDiario) {		
		this(LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy")), taxaAoAno, fatorDiario);		
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
