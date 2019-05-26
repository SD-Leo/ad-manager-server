package com.brolabs.admanager.server.repo;

import com.brolabs.admanager.server.model.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 2019-05-26
 *
 * @author Starovoytov Danil
 */
public interface AdCampaignRepository extends MongoRepository<Campaign, String> {

//    @Query("{ 'name' : ?0 }")
    List<Campaign> findCampaignsByPointsIn(String adPointId);

}
