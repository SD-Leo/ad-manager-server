package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.exception.NotFoundAdPoint;
import com.brolabs.admanager.server.exception.NotFoundOrganization;
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
                .build();
        adpoints.put(adPoint.getId(), adPoint);
    }

    public List<AdPoint> getAdPoints() {
        return new ArrayList<>(adpoints.values());
    }
    public AdPoint getAdPoint(String adPointId) {
        return adpoints.get(adPointId);
    }

    public AdPoint create(String organizationId, AdPoint point) {
        String id = UUID.randomUUID().toString();
        point.setId(id);
        point.setOrganizationId(organizationId);
        return point;
    }

    public AdPoint deleteAdPoint(String organizationId, String adPointId) {
        Map<String, AdPoint> organizationPoints = adpoints;
        if (organizationPoints == null) {
            throw new NotFoundOrganization();
        }
        AdPoint adPoint = organizationPoints.get(adPointId);
        if (adPoint == null) {
            throw new NotFoundAdPoint();
        }
        return adPoint;
    }

}
