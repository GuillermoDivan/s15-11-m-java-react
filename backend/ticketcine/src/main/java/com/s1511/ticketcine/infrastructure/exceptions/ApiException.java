package com.s1511.ticketcine.infrastructure.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
public class ApiException {
    private final String errorMessage;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}