package com.example.RoomManagement.service;

import com.example.RoomManagement.dto.request.RoomDto;
import com.example.RoomManagement.mapper.RoomMapper;
import com.example.RoomManagement.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
