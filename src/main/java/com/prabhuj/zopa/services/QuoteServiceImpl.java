package com.prabhuj.zopa.services;

import com.prabhuj.zopa.models.Lender;
import com.prabhuj.zopa.models.Quote;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class QuoteServiceImpl implements QuoteService{

    private static final Integer TERM_IN_MONTHS = 36;

    @Override
    public Double getInterestRate(List<Lender> lenders) {
        double totalAmount = 0.0;
        double totalWeight = 0.0;
        for(Lender lender : lenders){
            totalAmount = totalAmount + Double.valueOf(lender.getAvailableAmount());
            totalWeight = totalWeight + lender.getRate().doubleValue() * Double.valueOf(lender.getAvailableAmount());
        }
        Double interestRate = totalWeight/totalAmount;
        return Quote.round(interestRate,2);
    }

    @Override
    public Double getMonthlyRepayment(Integer requestedAmount, Double rate) {
        BigDecimal rateDecimal = new BigDecimal(rate);
        BigDecimal monthlyRepayments = getMonthlyRate(rateDecimal).multiply(BigDecimal.valueOf(requestedAmount))
                .divide(BigDecimal.valueOf(1)
                        .subtract((BigDecimal.valueOf(1)
                                .add(getMonthlyRate(rateDecimal))
                                .pow(-TERM_IN_MONTHS, MathContext.DECIMAL64))), RoundingMode.HALF_UP);
        return Quote.round(monthlyRepayments.doubleValue(),2);
    }

    @Override
    public Double getTotalRepayment(Integer requestedAmount, Double rate) {
        double totalRepayment = getMonthlyRepayment(requestedAmount, rate) * TERM_IN_MONTHS;
        return Quote.round(totalRepayment, 2);
    }

    private static BigDecimal getMonthlyRate(BigDecimal rate) {
        return rate.divide(new BigDecimal(12), 100, RoundingMode.HALF_UP);
    }


}
