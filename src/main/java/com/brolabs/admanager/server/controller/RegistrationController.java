package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.model.AdDevice;
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
    public AdDevice register(@RequestParam("code") String code) {
        AdDevice device = new AdDevice();
        String token = registrationService.register(code);
        device.setToken(token);
        return device;
    }

}
