package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(LoginFailed.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
    public ErrorResponseStructure handleLoginFailed(LoginFailed ex) {
        return new ErrorResponseStructure(ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
    }
}