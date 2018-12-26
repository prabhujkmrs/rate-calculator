package com.prabhuj.zopa.models;

import java.math.BigDecimal;

public class Lender implements Comparable<Lender> {
    private String name;
    private BigDecimal rate;
    private Integer availableAmount;

    public Lender(String name, BigDecimal rate, Integer availableAmount) {
        this.name = name;
        this.rate = rate;
        this.availableAmount = availableAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
    }

    @Override
    public int compareTo(Lender lender) {
        return getRate().compareTo(lender.getRate());
    }
}
