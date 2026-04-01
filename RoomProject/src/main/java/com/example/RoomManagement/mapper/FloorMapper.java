package com.example.RoomManagement.mapper;

import com.example.RoomManagement.dto.request.FloorDto;
import com.example.RoomManagement.model.Block;
import com.example.RoomManagement.model.Floor;
import com.example.RoomManagement.repository.IBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FloorMapper {
    @Autowired
    private IBlockRepository blockRepository;
    public Floor convertToEntity(FloorDto floorDto) {
        Floor floor = new Floor();
        floor.setFloorName(floorDto.getFloorName());
        floor.setLevel(floorDto.getLevel());
        Block block  = blockRepository.findById(floorDto.getBlockId()).orElseThrow(()->new RuntimeException("Block not found"));
        floor.setBlock(block);
        return floor;
    }
}
