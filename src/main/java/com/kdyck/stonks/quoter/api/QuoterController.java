package com.kdyck.stonks.quoter.api;

import com.kdyck.stonks.quoter.config.QuoterConfiguration;
import com.kdyck.stonks.quoter.exceptions.QuoterException;
import com.kdyck.stonks.quoter.services.QuoterService;
import com.kdyck.stonks.quoter.utils.ControllerValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@ControllerAdvice
public class QuoterController {

    private final QuoterConfiguration configuration;
    private final QuoterService quoterService;

    @Autowired
    public QuoterController(QuoterConfiguration configuration, QuoterService quoterService) {
        this.configuration = configuration;
        this.quoterService = quoterService;
    }

    @GetMapping("/getPrice")
    public ResponseEntity<String> getPriceBySymbol(@RequestParam(value = "symbol") String symbol)
            throws QuoterException {
        ControllerValidator.validSymbols(symbol, configuration);
        return quoterService.getPriceBySymbol(symbol);
    }
}
