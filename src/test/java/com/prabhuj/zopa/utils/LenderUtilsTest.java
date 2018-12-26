package com.prabhuj.zopa.utils;

import com.prabhuj.zopa.models.Lender;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LenderUtilsTest {

    private List<Lender> lendersList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        lendersList.add(new Lender("Alex", BigDecimal.valueOf(0.065), 300));
        lendersList.add(new Lender("Gary", BigDecimal.valueOf(0.075), 700));
        lendersList.add(new Lender("Sophie", BigDecimal.valueOf(0.085), 300));
    }

    @Test
    public void shouldLoadLendersFromCsvAndPopulatetheLendersList() throws IOException {
        String filepath = "src/test/resources/test-data.csv";
        List<Lender> lenderList = LenderUtils.getLendersList(filepath);

        Lender l1 = lenderList.get(0);
        assertEquals("Bob", l1.getName());
        assertEquals(BigDecimal.valueOf(0.075), l1.getRate());
        assertEquals(Integer.valueOf("640"), l1.getAvailableAmount());

        Lender l2 = lenderList.get(1);
        assertEquals("Jane", l2.getName());
        assertEquals(BigDecimal.valueOf(0.069), l2.getRate());
        assertEquals(Integer.valueOf("480"), l2.getAvailableAmount());
    }

    @Test
    public void shouldSelectTheRequiredLendersForTheLoanAmount1000() throws Exception {
        List<Lender> selectedLendersList = LenderUtils.getRequiredLenders(1000,lendersList);
        assertEquals(2,selectedLendersList.size());
        assertEquals(selectedLendersList.get(0).getAvailableAmount().longValue(),300);
        assertEquals(selectedLendersList.get(1).getAvailableAmount().longValue(),700);
    }

    @Test(expected=Exception.class)
    public void shouldThrowExceptionIfRequiredAmountGreaterThan1000() throws Exception {
        Integer AMOUNT = 1500;
        LenderUtils.getRequiredLenders(AMOUNT,lendersList);
    }

}
