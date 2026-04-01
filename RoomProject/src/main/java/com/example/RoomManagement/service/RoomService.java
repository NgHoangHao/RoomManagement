package com.example.RoomManagement.service;

import com.example.RoomManagement.dto.request.RoomDto;
import com.example.RoomManagement.dto.response.GetDeviceDto;
import com.example.RoomManagement.dto.response.GetRoomDto;
import com.example.RoomManagement.mapper.RoomMapper;
import com.example.RoomManagement.model.Room;
import com.example.RoomManagement.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private IRoomRepository roomRepository;
    @Autowired
    private RoomMapper roomMapper;
    public RoomDto addNewRoom(RoomDto roomDto) {
        roomRepository.save(roomMapper.convertToEntity(roomDto));
        return roomDto;
    }

    public List<GetRoomDto> getAllRoomsWithDevices() {
        List<Room> rooms = roomRepository.findAllWithDevices();
        return rooms.stream().map(room -> {
            List<GetDeviceDto> devices = room.getRoomDevices().stream()
                    .map(rd -> new GetDeviceDto(
                            rd.getDevice().getId(),
                            rd.getDevice().getName(),
                            rd.getQuantity()
                    ))
                    .toList();
            return new GetRoomDto(
                    room.getId(),
                    room.getName(),
                    devices
            );
        }).toList();
    }
}
