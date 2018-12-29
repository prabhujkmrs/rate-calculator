package com.prabhuj.zopa.services;

import com.prabhuj.zopa.models.Lender;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuoteServiceTest {

    private List<Lender> lendersList = new ArrayList<>();

    private QuoteService quoteService = new QuoteServiceImpl();

    @Before
    public void setUp() {
        lendersList.add(new Lender("Alex", BigDecimal.valueOf(0.065), 300));
        lendersList.add(new Lender("Gary", BigDecimal.valueOf(0.075), 700));
        lendersList.add(new Lender("Sophie", BigDecimal.valueOf(0.085), 300));
    }

    @Test
    public void shouldReturnInterestRateForTheListOfLenderDetails() {
        Double actualRate = quoteService.getInterestRate(lendersList);
        Double expectedRate = 0.08;
        assertEquals(expectedRate,actualRate);
    }

    @Test
    public void shouldReturnMonthlyRepaymentAmountForGivenLoanAmountAndRate(){
        Integer loanAmount = 1000;
        Double interestRate = 0.08;
        Double expectedRepaymentAmount= 31.34;
        Double actualRepaymentAmount = quoteService.getMonthlyRepayment(loanAmount,interestRate);
        assertEquals(expectedRepaymentAmount,actualRepaymentAmount);
    }

    @Test
    public void shouldReturnTotalRepaymentAmountForGivenLoanAmountAndRate(){
        Integer loanAmount = 1000;
        Double interestRate = 0.08;
        Double expectedRepaymentAmount= 1128.24;
        Double actualRepaymentAmount = quoteService.getTotalRepayment(loanAmount,interestRate);
        assertEquals(expectedRepaymentAmount,actualRepaymentAmount);
    }

}
