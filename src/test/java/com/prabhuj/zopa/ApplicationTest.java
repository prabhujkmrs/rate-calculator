package com.prabhuj.zopa;

import com.prabhuj.zopa.utils.LenderUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ApplicationTest {

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowFileNotFoundExceptionForInvalidFilePath() throws IOException {
        String filepath = "invalid-path.csv";
        LenderUtils.getLendersList(filepath);
    }

    @Test
    public void testApplicationMain(){
        Application.main(new String[] {"src/test/resources/test-data.csv", "1000"});

    }

}
