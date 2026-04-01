package com.example.RoomManagement.service;

import com.example.RoomManagement.dto.request.RoomDeviceRequest;
import com.example.RoomManagement.mapper.RoomDeviceMapper;
import com.example.RoomManagement.repository.IRoomDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomDeviceService {
    @Autowired
    private IRoomDeviceRepository roomDeviceRepository;
    @Autowired
    private RoomDeviceMapper roomDeviceMapper;
    public RoomDeviceRequest addNewRoomDevice(RoomDeviceRequest dto) {
        roomDeviceRepository.save(roomDeviceMapper.convertToEntity(dto));
        return dto;
    }
}
