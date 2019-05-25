package com.brolabs.admanager.server.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 2019-05-25
 *
 * @author Starovoytov Danil
 */
@Service
public class RegistrationService {

    public String register(String code) {
        return UUID.randomUUID().toString();
    }
}
