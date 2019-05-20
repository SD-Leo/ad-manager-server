package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.exception.NotFoundAdPoint;
import com.brolabs.admanager.server.exception.NotFoundOrganization;
import com.brolabs.admanager.server.model.AdPoint;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdPointService {

    private Map<String, Map<String, AdPoint>> adpoints = new HashMap<>();

    public List<AdPoint> getAdPoints(String organizationId) {
        return new ArrayList<>(adpoints.get(organizationId).values());
    }
    public AdPoint getAdPoint(String organizationId, String adPointId) {
        return adpoints.get(organizationId).get(adPointId);
    }

    public AdPoint create(String organizationId, AdPoint point) {
        String id = UUID.randomUUID().toString();
        point.setId(id);
        point.setOrganizationId(organizationId);
        return point;
    }

    public AdPoint deleteAdPoint(String organizationId, String adPointId) {
        Map<String, AdPoint> organizationPoints = adpoints.get(organizationId);
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
