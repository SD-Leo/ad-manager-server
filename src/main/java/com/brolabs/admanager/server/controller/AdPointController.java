package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.model.AdPoint;
import com.brolabs.admanager.server.service.AdPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdPointController {

    @Autowired
    private AdPointService adPointService;

    @GetMapping("/adpoints")
    public List<AdPoint> getPoints() {
        return adPointService.getAdPoints();
    }

    @GetMapping("/adpoints/{pointId}")
    public AdPoint getPoint(@PathVariable String pointId) {
        return adPointService.getAdPoint(pointId);
    }

}
