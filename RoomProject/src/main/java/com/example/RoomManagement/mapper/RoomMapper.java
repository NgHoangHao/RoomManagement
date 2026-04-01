package com.example.RoomManagement.mapper;

import com.example.RoomManagement.dto.request.RoomDto;
import com.example.RoomManagement.model.Floor;
import com.example.RoomManagement.model.Room;
import com.example.RoomManagement.repository.IFloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    @Autowired
    private IFloorRepository floorRepository;
    public Room convertToEntity(RoomDto roomDto) {
        Room room = new Room();
        room.setName(roomDto.getName());
        room.setDescription(roomDto.getDescription());
        Floor floor = floorRepository.findById(roomDto.getFloorId()).orElseThrow(()->new RuntimeException("Floor not found"));
        room.setFloor(floor);
        return room;
    }
}
