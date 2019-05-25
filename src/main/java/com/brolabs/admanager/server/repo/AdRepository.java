package com.brolabs.admanager.server.repo;

import com.brolabs.admanager.server.model.Ad;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2019-05-25
 *
 * @author Starovoytov Danil
 */
public interface AdRepository extends MongoRepository<Ad, String> {

}
