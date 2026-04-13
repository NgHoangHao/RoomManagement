package com.example.RoomManagement.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "tuya")
public class TuyaConfig {
    private String clientId;
    private String clientSecret;
    private String baseUrl;
}