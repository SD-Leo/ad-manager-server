package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.model.AdPoint;
import com.brolabs.admanager.server.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 2019-05-25
 *
 * @author Starovoytov Danil
 */
@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public AdPoint register(@RequestParam("code") String code) {
        return registrationService.register(code);
    }

    @PostMapping("/register/generate/{pointId}")
    public String generateCode(@PathVariable String pointId) {
        return registrationService.generateCode(pointId);
    }

}
