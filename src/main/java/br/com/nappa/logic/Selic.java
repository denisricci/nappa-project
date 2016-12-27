package br.com.nappa.logic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Selic {

	private LocalDate inicio;
	private LocalDate fim;
	private BigDecimal taxa;

	public Selic(LocalDate inicio, LocalDate fim, BigDecimal taxa) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.taxa = taxa;
	}

	public Selic(String inicio, String fim, BigDecimal taxa) {		
		super();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.inicio = LocalDate.parse(inicio, formatter);
		if (fim != null)
			this.fim = LocalDate.parse(fim, formatter);
		this.taxa = taxa;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}
	
	@Override
	public String toString() {	
		return inicio + " - " + fim + " taxa: " + taxa;
	}

}
