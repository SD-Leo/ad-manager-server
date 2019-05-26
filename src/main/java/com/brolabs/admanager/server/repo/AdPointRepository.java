package com.brolabs.admanager.server.repo;

import com.brolabs.admanager.server.model.AdPoint;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2019-05-26
 *
 * @author Starovoytov Danil
 */
public interface AdPointRepository extends MongoRepository<AdPoint, String> {

    AdPoint findAdPointByToken(String token);

}
