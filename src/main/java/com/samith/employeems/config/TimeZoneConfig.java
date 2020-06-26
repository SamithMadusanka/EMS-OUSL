package com.samith.employeems.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
public class TimeZoneConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeZoneConfig.class);

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Colombo"));
        LOGGER.info("Default timezone configured : {}", TimeZone.getDefault());
    }
}
