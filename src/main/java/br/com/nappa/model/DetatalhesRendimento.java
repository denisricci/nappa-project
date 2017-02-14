package br.com.nappa.model;

import java.math.BigDecimal;

public class DetatalhesRendimento {

	private BigDecimal valorLiquido;
	private BigDecimal valorBruto;
	private BigDecimal impostoDeRenda;
	private BigDecimal taxasAdministrativas;

	public DetatalhesRendimento() {
	}

	public DetatalhesRendimento(BigDecimal valorLiquido, BigDecimal valorBruto, BigDecimal impostoDeRenda) {
		super();
		this.valorLiquido = valorLiquido;
		this.valorBruto = valorBruto;
		this.impostoDeRenda = impostoDeRenda;
	}

	public DetatalhesRendimento(BigDecimal valorLiquido, BigDecimal valorBruto, BigDecimal impostoDeRenda,
			BigDecimal taxasAdministrativas) {
		super();
		this.valorLiquido = valorLiquido;
		this.valorBruto = valorBruto;
		this.impostoDeRenda = impostoDeRenda;
		this.taxasAdministrativas = taxasAdministrativas;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getImpostoDeRenda() {
		return impostoDeRenda;
	}

	public void setImpostoDeRenda(BigDecimal impostoDeRenda) {
		this.impostoDeRenda = impostoDeRenda;
	}

	public BigDecimal getTaxasAdministrativas() {
		return taxasAdministrativas;
	}

	public void setTaxasAdministrativas(BigDecimal taxasAdministrativas) {
		this.taxasAdministrativas = taxasAdministrativas;
	}
}
