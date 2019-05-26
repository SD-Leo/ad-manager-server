package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.model.AdPoint;
import com.brolabs.admanager.server.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2019-05-25
 *
 * @author Starovoytov Danil
 */
@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public AdPoint register(@RequestParam("code") String code) {
        AdPoint adPoint = AdPoint.builder()
            .token(registrationService.register(code))
            .build();
        return adPoint;
    }

}
