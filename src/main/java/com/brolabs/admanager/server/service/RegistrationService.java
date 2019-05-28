package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.exception.InvalidRegistrationException;
import com.brolabs.admanager.server.exception.NotFoundAdException;
import com.brolabs.admanager.server.model.AdPoint;
import com.brolabs.admanager.server.model.internal.DbRegCode;
import com.brolabs.admanager.server.repo.AdPointRepository;
import com.brolabs.admanager.server.repo.RegCodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

/**
 * 2019-05-25
 *
 * @author Starovoytov Danil
 */
@Slf4j
@Service
public class RegistrationService {

    @Autowired
    private AdPointRepository adPointRepository;

    @Autowired
    private RegCodeRepository regCodeRepository;

    public AdPoint register(String code) {
        DbRegCode regCode = regCodeRepository.findByCode(code);
        if (regCode == null) {
            throw new NotFoundAdException("Code '" + code + "' is not found");
        }
        log.info("Expired: {}, Now: {}, is expired: {}", regCode.getExpired(), LocalDateTime.now(), regCode.getExpired().isAfter(LocalDateTime.now()));
        if (LocalDateTime.now().isAfter(regCode.getExpired())) {
            throw new InvalidRegistrationException("Code '" + code + "' is expired: " + regCode.getExpired());
        }
        String token = UUID.randomUUID().toString();
        log.info("Register device with token: {}", token);

        Optional<AdPoint> adPointOpt = adPointRepository.findById(regCode.getPointId());
        if (!adPointOpt.isPresent()) {
            throw new RuntimeException("Server error");
        }
        AdPoint adPoint = adPointOpt.get();
        adPoint.setToken(token);
        adPointRepository.save(adPoint);
        regCodeRepository.delete(regCode);
        return adPoint;
    }

    public String generateCode(String pointId) {
        Optional<AdPoint> byId = adPointRepository.findById(pointId);
        if (!byId.isPresent()) {
            throw new InvalidRegistrationException("Point with id '" + pointId + "' is not found ");
        }
        Random rnd = new Random();
        int rndCode = rnd.nextInt(90000) + 10000;
        DbRegCode code = new DbRegCode();
        code.setPointId(pointId);
        code.setCode(String.valueOf(rndCode));
        code.setExpired(LocalDateTime.now().plus(30, ChronoUnit.SECONDS));
        regCodeRepository.save(code);
        return code.getCode();
    }
}
