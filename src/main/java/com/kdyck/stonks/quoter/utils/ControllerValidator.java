package com.kdyck.stonks.quoter.utils;

import com.kdyck.stonks.quoter.config.QuoterConfiguration;
import com.kdyck.stonks.quoter.exceptions.QuoterException;
import org.apache.commons.lang3.StringUtils;

public class ControllerValidator {

    public static void validSymbols(String symbol, QuoterConfiguration configuration) throws QuoterException {
        if (StringUtils.isBlank(symbol)) {
            throw new QuoterException("Symbols must not be null", new Exception());
        }
    }

}
