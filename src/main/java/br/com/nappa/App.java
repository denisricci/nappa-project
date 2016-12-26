package br.com.nappa;

import java.io.IOException;

import br.com.nappa.logic.LoadSelic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        LoadSelic selic = new LoadSelic();
        selic.execute();
    }
}
