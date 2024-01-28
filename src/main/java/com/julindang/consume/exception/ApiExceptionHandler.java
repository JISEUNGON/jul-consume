package com.julindang.consume.exception;

import com.julindang.consume.exception.consume.ParameterNullOrEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ParameterNullOrEmptyException.class)
    public ResponseEntity<ApiErrorResponse> handleException(ParameterNullOrEmptyException ex) {
        return new ResponseEntity<>(
                    new ApiErrorResponse(
                            "JEP-001",
                            ex.getMessage()),
                    HttpStatus.BAD_REQUEST
                );
    }
}
