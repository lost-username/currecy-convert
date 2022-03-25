package com.converter.currencyconverter.handler;

import java.time.LocalDateTime;

import com.converter.currencyconverter.exception.ExceptionDetails;
import com.converter.currencyconverter.exception.ResourceNotFoundDetails;
import com.converter.currencyconverter.exception.ResourceNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDetails> handleResourceNotFoundException(
        ResourceNotFoundException exception) {
        return new ResponseEntity<>(
            ResourceNotFoundDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not Found")
                .detail(exception.getMessage())
                .developerMessage(exception.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }    

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
        Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
            .timestamp(LocalDateTime.now())
            .status(status.value())
            .title(ex.getCause().getMessage())
            .detail(ex.getMessage())
            .developerMessage(ex.getClass().getName())
            .build();
        return new ResponseEntity<>(exceptionDetails, headers, status);
    }
}
