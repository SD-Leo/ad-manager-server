package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.model.AdPoint;
import com.brolabs.admanager.server.repo.AdPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2019-05-28
 *
 * @author Starovoytov Danil
 */
@RestController
@RequestMapping("/api")
public class AdPointController {

    @Autowired
    private AdPointRepository repository;

    @GetMapping("/points")
    public List<AdPoint> getAll() {
        return repository.findAll();
    }

}
