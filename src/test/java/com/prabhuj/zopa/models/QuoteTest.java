package com.prabhuj.zopa.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuoteTest {
    private static final Integer LOAN_AMOUNT = 1000;
    private static final Double INTEREST_RATE = 0.08;
    private static final Double MONTHLY_AMOUNT= 31.34;
    private static final Double TOTAL_AMOUNT = 1128.24;

    private Quote quote = new Quote();

    @Test
    public void shouldReturnTheStringRepresentationOfQuote(){
        quote.setRate(INTEREST_RATE);
        quote.setRequestedAmount(LOAN_AMOUNT);
        quote.setMonthlyRepayment(MONTHLY_AMOUNT);
        quote.setTotalRepayment(TOTAL_AMOUNT);
        String actualText = quote.display();
        String expectedText = "Requested Amount: £1000\n" +
                "Rate: 8.0% \n" +
                "Monthly Repayments: £31.34 \n" +
                "Total Repayment: £1128.24";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void roundTest(){
        double value = 0.745;
        Double act = Quote.round(value,2);
        Double exp = 0.75;
        assertEquals(exp,act);
    }
}
