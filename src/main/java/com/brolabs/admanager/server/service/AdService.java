package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.model.Ad;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

import static com.brolabs.admanager.server.model.AdType.IMAGE_JPG;
import static com.brolabs.admanager.server.model.AdType.VIDEO_MP4;

@Service
public class AdService {

    HashMap<String, Ad> database = new HashMap<>();

    @PostConstruct
    public void init() {
        Ad ad1 = Ad.builder()
            .id("ad-1")
            .type(VIDEO_MP4)
            .url("/resources/10000_2s39jf9e8uf.mp4")
            .build();

        Ad ad2 = Ad.builder()
            .id("ad-2")
            .type(IMAGE_JPG)
            .url("/resources/10001_8jf29jf92asSd.jpg")
            .build();

        database.put(ad1.getId(), ad1);
        database.put(ad2.getId(), ad2);
    }

    public Ad getAd(String id) {
        return database.get(id);
    }
}
