package com.brolabs.admanager.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundOrganization extends RuntimeException {

    public NotFoundOrganization() {
        this("Organization is not found");
    }

    public NotFoundOrganization(String message) {
        super(message);
    }

    public NotFoundOrganization(String message, Throwable cause) {
        super(message, cause);
    }
}
