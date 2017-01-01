package br.com.nappa.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CDI implements IndiceEconomico {

	private LocalDate date;
	private BigDecimal fatorDiario;
	private BigDecimal taxaAoAno;

	public CDI(LocalDate date, BigDecimal fatorDiario, BigDecimal taxaAoAno) {
		super();
		this.date = date;
		this.fatorDiario = fatorDiario;
		this.taxaAoAno = taxaAoAno;
	}

	public CDI(String date, BigDecimal fatorDiario, BigDecimal taxaAoAno) {
		this(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")), taxaAoAno, fatorDiario);
	}

	public BigDecimal getTaxaAoAno() {
		return taxaAoAno;
	}

	@Override
	public LocalDate getDate() {
		return this.date;
	}

	@Override
	public BigDecimal getFatorDiario() {
		return this.fatorDiario;
	}

}
