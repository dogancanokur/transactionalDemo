package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Api Exception", value = HttpStatus.NOT_FOUND)
public class ApiException extends Exception {
    public ApiException(String message) {
        super(message);
    }
}
