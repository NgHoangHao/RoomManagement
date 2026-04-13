package com.example.RoomManagement.service;

import com.example.RoomManagement.dto.response.TuyaDeviceResponse;
import com.example.RoomManagement.model.DeviceData;
import com.example.RoomManagement.repository.DeviceDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceDataService {

    private final DeviceDataRepository repository;

    public void saveFromTuya(TuyaDeviceResponse res) {
        if (res == null || res.getResult() == null) return;

        var r = res.getResult();

        DeviceData data = new DeviceData();
        data.setDeviceId(r.getId());
        data.setName(r.getName());
        data.setOnline(r.getIs_online());
        data.setActiveTime(r.getActive_time());
        data.setUpdateTime(r.getUpdate_time());
        data.setCreatedAt(System.currentTimeMillis());

        repository.save(data);
    }
}
