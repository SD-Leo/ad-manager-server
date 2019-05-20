package com.brolabs.admanager.server.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Startup {

    @Bean
    public CommandLineRunner afterStart() {
        return args -> {
              log.info("To view UI go to http://localhost:8090");
              log.info("API available at http://localhost:8090/swagger-ui.html");
        };
    }
}
