package com.kdyck.stonks.quoter.exceptions;

import org.springframework.boot.web.server.WebServerException;

public class QuoterException extends WebServerException {

    public QuoterException(String message, Throwable cause) {
        super(message, cause);
    }
}
