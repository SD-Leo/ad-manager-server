package com.brolabs.admanager.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 2019-05-25
 *
 * @author Starovoytov Danil
 */
@Slf4j
@Service
public class RegistrationService {

    public String register(String code) {
        String token = UUID.randomUUID().toString();
        log.info("Register device with token: {}", token);
        return token;
    }
}
