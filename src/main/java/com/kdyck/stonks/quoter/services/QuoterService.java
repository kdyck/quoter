package com.kdyck.stonks.quoter.services;

import com.kdyck.stonks.quoter.config.QuoterConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class QuoterService {

    private final QuoterConfiguration configuration;
    private final RestTemplate restTemplate;

    @Autowired
    public QuoterService(QuoterConfiguration configuration, RestTemplate restTemplate) {
        this.configuration = configuration;
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getPriceBySymbol(String symbol) {

        log.info("Getting [{}] ticker price...", symbol.toUpperCase());
        String baseUrl = configuration.getBaseUrl();

        URI toUri = UriComponentsBuilder.newInstance()
                .scheme(configuration.getScheme())
                .host(baseUrl)
                .queryParam("token", configuration.getPublicToken())
                .queryParam("symbols", symbol)
                .build().toUri();
        log.info("Url: [{}]", toUri);

        ResponseEntity<String> responseEntity = restTemplate.exchange(String.valueOf(toUri),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class);

        log.info("Response: status-code=[{}], body={}",
                responseEntity.getStatusCode(), responseEntity.getBody());
        return responseEntity;
    }
}
