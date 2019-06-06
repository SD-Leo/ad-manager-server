package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.model.AdResponse;
import com.brolabs.admanager.server.service.AdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("/ads")
    public AdResponse getAds(@RequestParam("token") String token) {
        AdResponse response = adService.getAds(token);
        log.info("Get ads for token: {}", token);
        return response;
    }
}
