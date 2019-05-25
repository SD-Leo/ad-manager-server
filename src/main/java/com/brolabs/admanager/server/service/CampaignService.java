package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.model.AdSettings;
import com.brolabs.admanager.server.model.Campaign;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CampaignService {

    HashMap<String, Campaign> database = new HashMap<>();

    @PostConstruct
    public void init() {
        Campaign campaign1 = Campaign
            .builder()
            .id("campaign-1")
            .settings(AdSettings
                .builder()
                .dateStart(LocalDate.of(2019, 5, 10))
                .dateEnd(LocalDate.of(2019, 8, 20))
                .build())
            .ad("ad-1")
            .point("point-1")
            .point("point-2")
            .build();

        Campaign campaign2 = Campaign
            .builder()
            .id("campaign-2")
            .settings(AdSettings
                .builder()
                .dateStart(LocalDate.of(2019, 5, 10))
                .dateEnd(LocalDate.of(2019, 8, 20))
                .build())
            .ad("ad-2")
            .point("point-1")
            .build();

        database.put(campaign1.getId(), campaign1);
        database.put(campaign2.getId(), campaign2);
    }

    public Campaign getCampaign(String id) {
        return database.get(id);
    }

    public List<Campaign> getCampaigns() {
        return new ArrayList<>(database.values());
    }
}
