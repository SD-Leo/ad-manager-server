package com.brolabs.admanager.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundAdPoint extends RuntimeException {

    public NotFoundAdPoint() {
        this("Advertisement point is not found");
    }

    public NotFoundAdPoint(String message) {
        super(message);
    }

    public NotFoundAdPoint(String message, Throwable cause) {
        super(message, cause);
    }

}
