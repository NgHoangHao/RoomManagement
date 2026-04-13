package com.example.RoomManagement.service;

import com.example.RoomManagement.config.TuyaConfig;
import com.example.RoomManagement.dto.response.TuyaDeviceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;
@Slf4j
@Service
@RequiredArgsConstructor
public class TuyaService {

    private final TuyaConfig config;
    private final RestTemplate restTemplate;
    private String cachedToken;
    private long expireTime = 0;

    // ===== SIGN =====
    private String sign(String str, String secret) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            mac.init(key);
            byte[] bytes = mac.doFinal(str.getBytes());
            return Hex.encodeHexString(bytes).toUpperCase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ===== GET TOKEN =====
    public String getAccessToken() {
        if (cachedToken != null && System.currentTimeMillis() < expireTime) {
            return cachedToken;
        }

        log.info("Fetching new Tuya token...");
        long t = System.currentTimeMillis();

        String path = "/v1.0/token?grant_type=1";

        String emptyBodyHash = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";

        String stringToSign = "GET\n" +
                emptyBodyHash + "\n" +
                "\n" +
                path;

        String content = config.getClientId() + t + stringToSign;

        String sign = sign(content, config.getClientSecret());

        HttpHeaders headers = new HttpHeaders();
        headers.set("client_id", config.getClientId());
        headers.set("sign", sign);
        headers.set("t", String.valueOf(t));
        headers.set("sign_method", "HMAC-SHA256");

        HttpEntity<?> entity = new HttpEntity<>(headers);
        String url = config.getBaseUrl() + path;
        System.out.println("CALL URL: " + url);
        ResponseEntity<Map> response = restTemplate.exchange(
                config.getBaseUrl() + path,
                HttpMethod.GET,
                entity,
                Map.class
        );

        Map body = response.getBody();

        System.out.println("Tuya token response: " + body);

        if (body == null || !Boolean.TRUE.equals(body.get("success"))) {
            throw new RuntimeException("Tuya API error: " + body);
        }

        Map result = (Map) body.get("result");

        if (result == null) {
            throw new RuntimeException("Result null: " + body);
        }

        // ===== LƯU CACHE =====
        cachedToken = (String) result.get("access_token");

        // Tuya trả expire_time (giây)
        Integer expire = (Integer) result.get("expire_time");

        // trừ 60s để tránh hết hạn đột ngột
        expireTime = System.currentTimeMillis() + (expire - 60) * 1000L;

        return cachedToken;
    }
    // ===== GET DEVICE =====
    public TuyaDeviceResponse getDevice(String deviceId) {
        String token = getAccessToken();
        long t = System.currentTimeMillis();

        String path = "/v2.0/cloud/thing/" + deviceId;

        String emptyBodyHash = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";

        String stringToSign = "GET\n" +
                emptyBodyHash + "\n" +
                "\n" +
                path;
        String signStr = config.getClientId() + token + t + stringToSign;
        String sign = sign(signStr, config.getClientSecret());

        HttpHeaders headers = new HttpHeaders();
        headers.set("client_id", config.getClientId());
        headers.set("access_token", token);
        headers.set("sign", sign);
        headers.set("t", String.valueOf(t));
        headers.set("sign_method", "HMAC-SHA256");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<TuyaDeviceResponse> response = restTemplate.exchange(
                config.getBaseUrl() + path,
                HttpMethod.GET,
                entity,
                TuyaDeviceResponse.class
        );

        return response.getBody();
    }
}
