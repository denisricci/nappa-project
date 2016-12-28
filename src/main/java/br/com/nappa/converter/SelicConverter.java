package br.com.nappa.converter;

public class SelicConverter {
	
	public static double paraTaxaDiaria(double taxaAnual){
		return Math.pow((taxaAnual/100)+1,1d/252d);		
	}
	
}
