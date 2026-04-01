package com.example.RoomManagement.service;

import com.example.RoomManagement.dto.request.FloorDto;
import com.example.RoomManagement.mapper.FloorMapper;
import com.example.RoomManagement.repository.IFloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorService {
    @Autowired
    private IFloorRepository floorRepository;
    @Autowired
    private FloorMapper floorMapper;
    public FloorDto addNewFloor(FloorDto dto) {
        floorRepository.save(floorMapper.convertToEntity(dto));
        return dto;
    }
}
