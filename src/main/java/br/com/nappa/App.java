package br.com.nappa;

import java.io.IOException;
import java.time.LocalDate;

import br.com.nappa.utils.SelictUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println(SelictUtils.getTaxaDoDia(LocalDate.now()));    	
    }
}
