package br.com.nappa.converter;

public class TaxaDeJurosConverter  {
	
	public static double paraMensal(double taxaAnual){				
		return (Math.pow((taxaAnual/100)+1,1d/12d)-1) * 100;
	}
	
	public static double paraAnual(double taxaMensal){
		return (Math.pow((taxaMensal/100)+1, 12d)-1) * 100;
	}
}
