package com.example.RoomManagement.scheduler;

import com.example.RoomManagement.service.DeviceDataService;
import com.example.RoomManagement.service.TuyaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TuyaScheduler {

    private final TuyaService tuyaService;
    private final DeviceDataService deviceDataService;

    private final String DEVICE_ID = "ebe802f5526b1bfee8mp2z";

    @Scheduled(cron = "0 * * * * *") // mỗi 1 phút
    public void fetchAndSave() {
        try {
            log.info("Fetching device...");

            var res = tuyaService.getDevice(DEVICE_ID);

            deviceDataService.saveFromTuya(res);

        } catch (Exception e) {
            log.error("Error fetch device", e);
        }
    }
}
