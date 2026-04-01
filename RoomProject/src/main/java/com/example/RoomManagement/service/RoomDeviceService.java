package com.example.RoomManagement.service;

import com.example.RoomManagement.dto.request.DeleteDeviceRequest;
import com.example.RoomManagement.dto.request.RoomDeviceRequest;
import com.example.RoomManagement.dto.request.UpdateDeviceRequest;
import com.example.RoomManagement.mapper.RoomDeviceMapper;
import com.example.RoomManagement.model.RoomDevice;
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
        RoomDevice findRoomDevice = roomDeviceRepository.findByRoomIdAndDeviceId(dto.getRoomId(), dto.getDeviceId());
        if(findRoomDevice != null) {
            throw new RuntimeException("Device already exists in this room");
        }
        roomDeviceRepository.save(roomDeviceMapper.convertToEntity(dto));
        return dto;
    }

    public UpdateDeviceRequest updateRoomDevice(UpdateDeviceRequest dto) {
        RoomDevice findRoomDevice = roomDeviceRepository.findByRoomIdAndDeviceId(dto.getRoomId(), dto.getDeviceId());
        if(findRoomDevice == null) {
            throw new RuntimeException("Device does not exist in this room");
        }
        findRoomDevice.setQuantity(dto.getQuantity());
        roomDeviceRepository.save(findRoomDevice);
        return dto;
    }

    public String deleteRoomDevice(DeleteDeviceRequest dto) {
        RoomDevice findRoomDevice = roomDeviceRepository.findByRoomIdAndDeviceId(dto.getRoomId(), dto.getDeviceId());
        if(findRoomDevice == null) {
            throw new RuntimeException("Device does not exist in this room");
        }
        roomDeviceRepository.delete(findRoomDevice);
        return "Deleted device from this room";
    }
}
