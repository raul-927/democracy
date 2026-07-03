package com.democracy.accounting.infrastructure.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Sinks;

@Slf4j
@Configuration
public class PublisherConfig {

    Logger LOGGER = LoggerFactory.getLogger(PublisherConfig.class);

    @Bean
    public Sinks.Many returnSiksMany(){
        LOGGER.info("init Sinks.Many...");
        return Sinks.many().multicast().onBackpressureBuffer();
    }
}
