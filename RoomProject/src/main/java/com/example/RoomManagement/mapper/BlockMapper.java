package com.example.RoomManagement.mapper;

import com.example.RoomManagement.dto.request.BlockDto;
import com.example.RoomManagement.dto.response.GetBlockDto;
import com.example.RoomManagement.model.Block;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlockMapper {
    public Block convertToEntity(BlockDto blockDto) {
        Block block = new Block();
        block.setName(blockDto.getName());
        return block;
    }

    public GetBlockDto convertToDto(Block block) {
        GetBlockDto getBlockDto = new GetBlockDto();
        getBlockDto.setName(block.getName());
        getBlockDto.setId(block.getId());
        return getBlockDto;
    }

    public List<GetBlockDto> convertToListDto(List<Block> blocks) {
        return blocks.stream().map(this::convertToDto).toList();
    }
}
