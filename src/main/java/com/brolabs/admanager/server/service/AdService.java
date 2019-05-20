package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.model.Ad;
import com.brolabs.admanager.server.model.AdSettings;
import com.brolabs.admanager.server.model.AdType;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Service
public class AdService {

    private Map<String, Map<String, Ad>> ads = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Ad> adsOfPoint1 = new HashMap<>();
        Map<String, Ad> adsOfPoint2 = new HashMap<>();

        AdSettings settings = new AdSettings();
        settings.setDateStart(LocalDate.of(2019, Month.MAY, 10));
        settings.setDateEnd(LocalDate.of(2019, Month.MAY, 20));
        Ad ad = new Ad();
        ad.setId("10000");
        ad.setSettings(settings);
        ad.setType(AdType.VIDEO_MP4);
        ad.setUrl("/resources/10000_2s39jf9e8uf.mp4");
        adsOfPoint1.put(ad.getId(), ad);
        adsOfPoint2.put(ad.getId(), ad);

        settings = new AdSettings();
        settings.setDateStart(LocalDate.of(2019, Month.MAY, 19));
        settings.setDateEnd(LocalDate.of(2019, Month.MAY, 22));
        ad = new Ad();
        ad.setId("10001");
        ad.setSettings(settings);
        ad.setType(AdType.IMAGE_JPG);
        ad.setUrl("/resources/10001_8jf29jf92asSd.jpg");
        adsOfPoint1.put(ad.getId(), ad);

        ads.put("1000", adsOfPoint1);
        ads.put("2000", adsOfPoint2);
    }

    public List<Ad> getAds(String pointId) {
        Map<String, Ad> adsOfPoint = ads.get(pointId);
        if (adsOfPoint == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(adsOfPoint.values());
    }

    public Ad getAd(String pointId, String adId) {
        Map<String, Ad> adsOfPoint = ads.get(pointId);
        if (adsOfPoint == null) {
            return null;
        }
        return adsOfPoint.get(adId);
    }
}
