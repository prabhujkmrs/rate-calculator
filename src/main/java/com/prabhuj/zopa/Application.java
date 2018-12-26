package com.prabhuj.zopa;

import com.prabhuj.zopa.models.Lender;
import com.prabhuj.zopa.models.Quote;
import com.prabhuj.zopa.services.QuoteService;
import com.prabhuj.zopa.services.QuoteServiceImpl;
import com.prabhuj.zopa.utils.LenderUtils;
import java.util.List;


public class Application{

    private static final int MIN_LOAN_VALUE = 1000;
    private static final int MAX_LOAN_VALUE = 15000;

    public static void main(String [] args) {
        try {
            String filepath = args[0];
            Integer amount = Integer.parseInt(args[1]);
            if(isValidAmount(amount)) {
                List<Lender> lendersList = LenderUtils.getLendersList(filepath);
                List<Lender> requiredLendersList = LenderUtils.getRequiredLenders(amount, lendersList);
                QuoteService quoteService = new QuoteServiceImpl();
                Double rate = quoteService.getInterestRate(requiredLendersList);
                Double monthlyRepayment = quoteService.getMonthlyRepayment(amount, rate);
                Double totalRepayment = quoteService.getTotalRepayment(amount, rate);
                Quote quote = new Quote();
                quote.setRate(rate);
                quote.setRequestedAmount(amount);
                quote.setMonthlyRepayment(monthlyRepayment);
                quote.setTotalRepayment(totalRepayment);
                System.out.println(quote.display());
            }
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Invalid input. Please enter CSV file as the first parameter and a loan amount as the second parameter");
        }
        catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static boolean isValidAmount(double amount) {
        if (amount < MIN_LOAN_VALUE || amount > MAX_LOAN_VALUE || amount % 100 != 0)
            throw new NumberFormatException("Amount not accepted.Please entered a number between "+MIN_LOAN_VALUE +" and "+MAX_LOAN_VALUE+" in multiples of 100");
        return true;
    }

}
