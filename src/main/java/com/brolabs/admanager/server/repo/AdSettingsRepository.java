package com.brolabs.admanager.server.repo;

import com.brolabs.admanager.server.model.AdSettings;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2019-05-26
 *
 * @author Starovoytov Danil
 */
public interface AdSettingsRepository extends MongoRepository<AdSettings, String> {
}
