package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.model.Ad;
import com.brolabs.admanager.server.model.Campaign;
import com.brolabs.admanager.server.service.AdService;
import com.brolabs.admanager.server.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private CampaignService campaignService;

    @GetMapping("/adpoints/{adpoint}/advertisements")
    public List<Ad> getAdsOfPoint(@PathVariable String adpoint) {
        List<Campaign> campaigns = campaignService.getCampaigns();
        List<Ad> ads = new ArrayList<>();
        for (Campaign campaign : campaigns) {
            if (campaign.getPoints().stream().anyMatch(pointId -> pointId.equals(adpoint))) {
                for (String adId : campaign.getAds()) {
                    ads.add(adService.getAd(adId));
                }
            }
        }
        return ads;
    }
}
