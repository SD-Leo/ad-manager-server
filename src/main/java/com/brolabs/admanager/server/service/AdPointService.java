package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.exception.NotFoundAdPoint;
import com.brolabs.admanager.server.model.AdPoint;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class AdPointService {

    private Map<String, AdPoint> adpoints = new HashMap<>();

    @PostConstruct
    public void init() {
        AdPoint adPoint = AdPoint.builder()
                .organizationId("111")
                .id("1000")
                .name("First ad point")
                .ad("10000")
                .ad("10001")
                .build();
        adpoints.put(adPoint.getId(), adPoint);
        adPoint = AdPoint.builder()
                .organizationId("222")
                .id("2000")
                .name("ad point 2")
                .ad("10000")
                .build();
        adpoints.put(adPoint.getId(), adPoint);
    }

    public List<AdPoint> getAdPoints() {
        return new ArrayList<>(adpoints.values());
    }
    public AdPoint getAdPoint(String adPointId) {
        return adpoints.get(adPointId);
    }

    public AdPoint create(AdPoint point) {
        Random rnd = new Random();
        String id = String.valueOf(rnd.nextInt(900) + 100);
        point.setId(id);
        adpoints.put(point.getOrganizationId(), point);
        return point;
    }

    public AdPoint delete(String adPointId) {

        AdPoint adPoint = adpoints.get(adPointId);
        if (adPoint == null) {
            throw new NotFoundAdPoint();
        }
        adpoints.remove(adPointId);
        return adPoint;
    }

}
