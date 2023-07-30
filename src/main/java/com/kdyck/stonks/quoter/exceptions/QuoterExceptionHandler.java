package com.kdyck.stonks.quoter.exceptions;

import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class QuoterExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {QuoterException.class})
    public ResponseEntity<Object> handleQuoteServiceException(
            WebServerException webServerException, WebRequest webRequest) {
        return handleExceptionInternal(
                webServerException,
                webServerException.getMessage(),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                webRequest);
    }
}
