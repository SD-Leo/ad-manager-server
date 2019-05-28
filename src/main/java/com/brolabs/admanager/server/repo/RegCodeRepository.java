package com.brolabs.admanager.server.repo;

import com.brolabs.admanager.server.model.internal.DbRegCode;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2019-05-28
 *
 * @author Starovoytov Danil
 */
public interface RegCodeRepository extends MongoRepository<DbRegCode, String> {

    DbRegCode findByCode(String code);

}
