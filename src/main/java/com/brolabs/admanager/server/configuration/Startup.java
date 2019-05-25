package com.brolabs.admanager.server.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Startup {

    private final ServerProperties serverProperties;

    public Startup(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    @Bean
    public CommandLineRunner afterStart() {
        return args -> {
            int port = serverProperties.getPort();
            log.info("To view UI go to http://localhost:{}", port);
            log.info("API available at http://localhost:{}/swagger-ui.html", port);
        };
    }
}
