package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.exception.NotFoundAdException;
import com.brolabs.admanager.server.model.AdPoint;
import com.brolabs.admanager.server.repo.AdPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/points")
    public AdPoint addPoint(@RequestBody AdPoint adPoint) {
        return repository.save(adPoint);
    }

    @DeleteMapping("/points/{pointId}")
    public void addPoint(@PathVariable String pointId) {
        if (!repository.existsById(pointId)) {
            throw new NotFoundAdException("Point with id '" + pointId + "' not found");
        }
        repository.deleteById(pointId);
    }

}
