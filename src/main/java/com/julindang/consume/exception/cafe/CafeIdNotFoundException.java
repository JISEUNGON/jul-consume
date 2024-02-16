package com.julindang.consume.exception.cafe;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class CafeIdNotFoundException extends RuntimeException {
    private String message;

    public CafeIdNotFoundException(final Long cafeId) {
        super(cafeId.toString());
        message = cafeId.toString();
    }
}
