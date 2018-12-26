package com.prabhuj.zopa.services;

import com.prabhuj.zopa.models.Lender;

import java.util.List;

public interface QuoteService {

    Double getInterestRate(List<Lender> lenders);

    Double getMonthlyRepayment(Integer requestedAmount, Double rate);

    Double getTotalRepayment(Integer requestedAmount, Double rate);

}
