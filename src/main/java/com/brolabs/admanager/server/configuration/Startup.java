package com.brolabs.admanager.server.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Startup {

    @Autowired
    private ServerProperties serverProperties;

    @Bean
    public CommandLineRunner afterStart() {
        return args -> {
            int port = serverProperties.getPort();
            log.info("To view UI go to http://localhost:{}", port);
            log.info("API available at http://localhost:{}/swagger-ui.html", port);
        };
    }
}
