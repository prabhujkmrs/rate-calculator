package com.prabhuj.zopa.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Quote {
    private Integer requestedAmount;
    private double rate;
    private double monthlyRepayment;
    private double totalRepayment;


    public Integer getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(Integer requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public double getTotalRepayment() {
        return totalRepayment;
    }

    public void setTotalRepayment(double totalRepayment) {
        this.totalRepayment = totalRepayment;
    }

    public static double round(double value, int places) {
        BigDecimal decimalValue = new BigDecimal(Double.toString(value));
        decimalValue = decimalValue.setScale(places, RoundingMode.HALF_UP);
        return decimalValue.doubleValue();
    }

    public String display() {
        return "Requested Amount: £" + this.requestedAmount + "\n" +
                "Rate: " + round(this.rate * 100,1) + "% \n" +
                "Monthly Repayments: £" + this.monthlyRepayment + " \n" +
                "Total Repayment: £" +this.totalRepayment;
    }

}
