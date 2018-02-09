package br.com.nappa.exceptios;

public class RetroactiveDateOutOfRangeException extends RuntimeException{

  private static final String MESSAGE = "The retroactive date range must be less or equal than today";


}
