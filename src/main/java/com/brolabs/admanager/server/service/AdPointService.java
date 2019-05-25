package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.model.AdPoint;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class AdPointService {

    private HashMap<String, AdPoint> database = new HashMap<>();

    @PostConstruct
    public void init() {
        AdPoint point1 = AdPoint
            .builder()
            .id("point-1")
            .name("Point 1")
            .build();

        AdPoint point2 = AdPoint
            .builder()
            .id("point-2")
            .name("Point 2")
            .build();

        database.put(point1.getId(), point1);
        database.put(point2.getId(), point2);
    }

    public AdPoint getPoint(String id) {
        return database.get(id);
    }

    public List<AdPoint> getAdPoints() {
        return new ArrayList<>(database.values());
    }

    public AdPoint create(AdPoint point) {
        point.setId(UUID.randomUUID().toString());
        database.put(point.getId(), point);
        return point;
    }
}
