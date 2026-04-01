package com.example.RoomManagement.mapper;

import com.example.RoomManagement.dto.request.BlockDto;
import com.example.RoomManagement.model.Block;
import org.springframework.stereotype.Component;

@Component
public class BlockMapper {
    public Block convertToEntity(BlockDto blockDto) {
        Block block = new Block();
        block.setName(blockDto.getName());
        return block;
    }
}
