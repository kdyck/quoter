package com.kdyck.stonks.quoter.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Data
@Configuration
@ConfigurationProperties(prefix = "iex")
public class QuoterConfiguration {

    private String baseUrl;

    private String scheme;

    @Value("${iex.token.public}")
    private String publicToken;

    @Value("${iex.token.secret")
    private String secretToken;

    @Value("${iex.defaultTickers")
    private String defaultTickers;
}
