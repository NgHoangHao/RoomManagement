package com.example.RoomManagement.service;

import com.example.RoomManagement.dto.request.DeviceDto;
import com.example.RoomManagement.mapper.DeviceMapper;
import com.example.RoomManagement.repository.IDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    @Autowired
    private IDeviceRepository deviceRepository;
    @Autowired
    private DeviceMapper deviceMapper;
    public DeviceDto addNewDevice(DeviceDto dto) {
        deviceRepository.save(deviceMapper.convertToEntity(dto));
        return dto;
    }
}
