package br.com.nappa.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadSelic {

	public void execute() throws IOException{
		BufferedReader br = null;
		String linha = "";
		
		br = new BufferedReader(new FileReader("selic.csv"));
		while((linha = br.readLine()) != null){
			String values[] = linha.split(";");
			
			for(String str: values){
				System.out.println(str);
			}
			
		}
		
		br.close();
	}
	
	
}
