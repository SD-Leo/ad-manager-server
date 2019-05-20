package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.model.Ad;
import com.brolabs.admanager.server.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("/adpoints/{adpoint}/advertisements")
    public List<Ad> getAdsOfPoint(@PathVariable String adpoint) {
        return adService.getAds(adpoint);
    }

    @GetMapping("/adpoints/{adpoint}/advertisements/{adId}")
    public Ad getAdsOfPoint(@PathVariable String adpoint, @PathVariable String adId) {
        return adService.getAd(adpoint, adId);
    }

}
