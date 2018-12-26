package com.prabhuj.zopa.utils;

import com.prabhuj.zopa.models.Lender;


import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class LenderUtils {

    public static List<Lender> getLendersList(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<Lender> lendersList = reader.lines().skip(1).map(mapToLender).collect(Collectors.toList());
        reader.close();
        return lendersList;
    }

    public static List<Lender> getRequiredLenders(Integer amount, List<Lender> lenderList) throws Exception {
        List<Lender> requiredLendersList = new ArrayList<>();
        Integer loanRequired = amount;
        Integer amountAvailableToLend = getMaxLoanValue(lenderList);

        if (loanRequired > amountAvailableToLend) {
            throw new Exception("Loan unavailable at this time.");
        }

        Collections.sort(lenderList);

        for (Lender lender : lenderList) {
            if (loanRequired <= 0) {
                break;
            }
            if (lender.getAvailableAmount() > loanRequired) {
                requiredLendersList.add(lender);
                loanRequired = 0;

            } else {
                loanRequired = loanRequired - lender.getAvailableAmount();
                requiredLendersList.add(lender);
            }
        }
        return requiredLendersList;
    }

    private static Function<String, Lender> mapToLender = (String line) -> {
        String[] column = line.split(",");
        String name = column[0];
        BigDecimal rate = new BigDecimal(column[1]);
        Integer availableAmount = Integer.valueOf(column[2]);
        return new Lender(name, rate, availableAmount);
    };

    private static int getMaxLoanValue(List<Lender> lenders) {
        return lenders.stream().mapToInt(Lender::getAvailableAmount).sum();
    }
}
