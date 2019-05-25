package com.brolabs.admanager.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundAdException extends RuntimeException {

    public NotFoundAdException() {
        this("Advertisement point is not found");
    }

    public NotFoundAdException(String message) {
        super(message);
    }

    public NotFoundAdException(String message, Throwable cause) {
        super(message, cause);
    }

}
