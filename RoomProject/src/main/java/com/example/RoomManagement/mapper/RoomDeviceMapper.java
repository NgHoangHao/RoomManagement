package com.example.RoomManagement.mapper;

import com.example.RoomManagement.dto.request.RoomDeviceRequest;
import com.example.RoomManagement.model.Device;
import com.example.RoomManagement.model.Room;
import com.example.RoomManagement.model.RoomDevice;
import com.example.RoomManagement.repository.IDeviceRepository;
import com.example.RoomManagement.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomDeviceMapper {
    @Autowired
    private IDeviceRepository deviceRepository;
    @Autowired
    private IRoomRepository roomRepository;
    public RoomDevice convertToEntity(RoomDeviceRequest dto){
        RoomDevice entity = new RoomDevice();
        Room room = roomRepository.findById(dto.getRoomId()).orElseThrow(()->new RuntimeException("Room not found"));
        Device device = deviceRepository.findById(dto.getDeviceId()).orElseThrow(()->new RuntimeException("Device not found"));
        entity.setRoom(room);
        entity.setDevice(device);
        entity.setQuantity(dto.getQuantity());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
