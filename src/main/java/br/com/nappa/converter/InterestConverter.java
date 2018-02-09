package br.com.nappa.converter;

public class InterestConverter {

  public static double yearlyToMonthly(double yearlyTax) {
    return (Math.pow((yearlyTax / 100) + 1, 1d / 12d) - 1) * 100;
  }

  public static double monthlyToYearly(double monthlyTax) {
    return (Math.pow((monthlyTax / 100) + 1, 12d) - 1) * 100;
  }

  public static double yearlyToDaily(double yealyTax) {
    return Math.pow((yealyTax / 100) + 1, 1d / 252d);
  }

}
