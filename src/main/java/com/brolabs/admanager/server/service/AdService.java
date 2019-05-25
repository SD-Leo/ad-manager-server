package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.model.*;
import com.brolabs.admanager.server.repo.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.brolabs.admanager.server.model.AdType.IMAGE_JPG;
import static com.brolabs.admanager.server.model.AdType.VIDEO_MP4;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    @PostConstruct
    public void init() {
        Ad ad1 = Ad.builder()
            .id("ad-1")
            .type(VIDEO_MP4)
            .url("/content/10000_2s39jf9e8uf.mp4")
            .build();

        Ad ad2 = Ad.builder()
            .id("ad-2")
            .type(IMAGE_JPG)
            .url("/content/10001_8jf29jf92asSd.jpg")
            .build();

        adRepository.save(ad1);
        adRepository.save(ad2);
    }

    public AdDeviceResponse getAds(String token) {
        AdDevice device = findDevice(token);
        Campaign campaign = findCampaignsForDevice(device);
        List<String> adIds = campaign.getAds();
        List<Ad> ads = findAds(adIds);

        return AdDeviceResponse.builder()
            .settings(campaign.getSettings())
            .ads(ads)
            .build();
    }

    private AdDevice findDevice(String token) {
        return AdDevice.builder()
            .build();
    }

    private Campaign findCampaignsForDevice(AdDevice device) {
        return Campaign.builder()
            .settings(AdSettings.builder()
                .dateStart(LocalDate.of(2019, Month.MAY, 19))
                .dateEnd(LocalDate.of(2019, Month.MAY, 21))
                .build())
            .ads(adRepository.findAll().stream().map(Ad::getId).collect(Collectors.toList()))
            .build();
    }

    private List<Ad> findAds(List<String> adIds) {
        Iterable<Ad> allById = adRepository.findAllById(adIds);
        List<Ad> ads = new ArrayList<>();
        allById.forEach(ads::add);
        return ads;
    }

}
