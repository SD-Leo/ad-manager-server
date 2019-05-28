package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.exception.NotFoundAdException;
import com.brolabs.admanager.server.model.AdPoint;
import com.brolabs.admanager.server.model.Campaign;
import com.brolabs.admanager.server.repo.AdCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private AdCampaignRepository repository;

    public List<Campaign> getCampaigns() {
        return repository.findAll();
    }

    public Campaign getCampaign(String id) {
        Optional<Campaign> opt = repository.findById(id);
        if (!opt.isPresent()) {
            throw new NotFoundAdException("Campaign is not found");
        }
        return opt.get();
    }

    public List<Campaign> getCampaigns(AdPoint adPoint) {
        return repository.findCampaignsByPointsIn(adPoint.getId());
    }

}
