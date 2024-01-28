package com.julindang.consume.exception.consume;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class ParameterNullOrEmptyException extends RuntimeException {
    private String message;

    public ParameterNullOrEmptyException(String message) {
        super(message);

        this.message = message;
    }
}
