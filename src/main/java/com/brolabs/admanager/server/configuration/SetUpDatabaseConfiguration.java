package com.brolabs.admanager.server.configuration;

import com.brolabs.admanager.server.model.Ad;
import com.brolabs.admanager.server.model.AdPoint;
import com.brolabs.admanager.server.model.AdSettings;
import com.brolabs.admanager.server.model.Campaign;
import com.brolabs.admanager.server.repo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

import static com.brolabs.admanager.server.model.AdType.IMAGE_JPG;
import static com.brolabs.admanager.server.model.AdType.VIDEO_MP4;

/**
 * 2019-05-26
 *
 * @author Starovoytov Danil
 */
@Slf4j
@Configuration
public class SetUpDatabaseConfiguration {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private AdPointRepository adPointRepository;

    @Autowired
    private AdSettingsRepository adSettingsRepository;

    @Autowired
    private AdCampaignRepository adCampaignRepository;

    @Autowired
    private RegCodeRepository regCodeRepository;

    @Bean
    public CommandLineRunner populateDatabase() {
        return args -> {
            adRepository.deleteAll();
            adPointRepository.deleteAll();
            adSettingsRepository.deleteAll();
            adCampaignRepository.deleteAll();
            regCodeRepository.deleteAll();
            log.info("Init database data");
            Ad ad1 = Ad.builder()
                .id("ad-1")
                .type(VIDEO_MP4)
                .url("/content/10000_2s39jf9e8uf.mp4")
                .build();

            Ad ad2 = Ad.builder()
                .id("ad-2")
                .type(IMAGE_JPG)
                .url("/content/10001_8jf29jf92asSd.jpg")
                .build();

            adRepository.save(ad1);
            adRepository.save(ad2);

            AdPoint point1 = AdPoint
                .builder()
                .id("ad-point-id-111")
//                .token("point-1") // token is null because point is unregistered
                .name("Point 1")
                .build();

            AdPoint point2 = AdPoint
                .builder()
                .id("ad-point-id-222")
//                .token("point-2") // token is null because point is unregistered
                .name("Point 2")
                .build();
            adPointRepository.save(point1);
            adPointRepository.save(point2);


            AdSettings settings1 = AdSettings
                .builder()
                .dateStart(LocalDate.of(2019, Month.MAY, 10))
                .dateEnd(LocalDate.of(2019, Month.AUGUST, 20))
                .build();
            AdSettings settings2 = AdSettings
                .builder()
                .dateStart(LocalDate.of(2019, Month.MAY, 1))
                .dateEnd(LocalDate.of(2019, Month.AUGUST, 1))
                .build();


            Campaign campaign1 = Campaign
                .builder()
                .id("campaign-1")
                .settings(settings1)
                .ad(ad1.getId())
                .point(point1.getId())
                .point(point2.getId())
                .build();

            Campaign campaign2 = Campaign
                .builder()
                .id("campaign-2")
                .settings(settings2)
                .ad(ad2.getId())
                .point(point1.getId())
                .build();

            adCampaignRepository.save(campaign1);
            adCampaignRepository.save(campaign2);
        };
    }

}
