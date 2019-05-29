package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.model.Ad;
import com.brolabs.admanager.server.model.AdPoint;
import com.brolabs.admanager.server.model.AdResponse;
import com.brolabs.admanager.server.model.Campaign;
import com.brolabs.admanager.server.repo.AdPointRepository;
import com.brolabs.admanager.server.repo.AdRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private AdPointRepository adPointRepository;

//    @Autowired
//    private AdSettingsRepository adSettingsRepository;

    @Autowired
    private CampaignService campaignService;

    public AdResponse getAds(String token) {
        AdPoint adPoint = adPointRepository.findAdPointByToken(token);
        List<Campaign> campaigns = campaignService.getCampaigns(adPoint);
        log.info("Campaigns: {}", campaigns);
//        AdSettings settings = adSettingsRepository.findAll().get(0);

        List<Ad> ads = new ArrayList<>();
        campaigns.forEach(campaign -> {
            List<Ad> adList = findAds(campaign.getAds());
            adList.forEach(ad -> ad.setSettings(campaign.getSettings()));
            ads.addAll(adList);
        });

        return AdResponse.builder()
            .ads(ads)
            .build();
    }

//    private AdPoint findAdPoint(String token) {
//        return AdPoint.builder()
//            .build();
//    }

//    private Campaign findCampaignsForAdPoint(AdPoint point) {
//        return Campaign.builder()
//            .settings(AdSettings.builder()
//                .dateStart(LocalDate.of(2019, Month.MAY, 19))
//                .dateEnd(LocalDate.of(2019, Month.MAY, 21))
//                .build())
//            .ads(adRepository.findAll().stream().map(Ad::getId).collect(Collectors.toList()))
//            .build();
//    }

    private List<Ad> findAds(List<String> adIds) {
        Iterable<Ad> allById = adRepository.findAllById(adIds);
        List<Ad> ads = new ArrayList<>();
        allById.forEach(ads::add);
        return ads;
    }

}
