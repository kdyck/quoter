package com.kdyck.stonks.quoter.tasks;

import com.kdyck.stonks.quoter.config.QuoterConfiguration;
import com.kdyck.stonks.quoter.services.QuoterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Component
public class CurrentTickerPriceTask {
    private static final long SCHEDULE = 60000;
    private static final long INIT_DELAY = 5000;
    private final QuoterService quoterService;
    private final QuoterConfiguration quoterConfiguration;

    @Autowired
    public CurrentTickerPriceTask(QuoterService quoterService, QuoterConfiguration quoterConfiguration) {
        this.quoterService = quoterService;
        this.quoterConfiguration = quoterConfiguration;
    }

    @Scheduled(fixedRate = SCHEDULE, initialDelay = INIT_DELAY)
    public void getCurrentTickerPrice() {
        log.info("Starting CurrentTickerPriceTask for date/time: {}", Instant.now());

        final String defaultTickers =
                quoterConfiguration.getDefaultTickers() != null ? quoterConfiguration.getDefaultTickers() : "voo, orcl";
        quoterService.getPriceBySymbol(defaultTickers);

        log.info("Finished CurrentTickerPriceTask for date/time: {}", Instant.now());
    }
}
