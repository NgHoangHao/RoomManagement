package com.example.RoomManagement.service;

import com.example.RoomManagement.dto.request.BlockDto;
import com.example.RoomManagement.dto.response.*;
import com.example.RoomManagement.mapper.BlockMapper;
import com.example.RoomManagement.repository.IBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlockService {
    @Autowired
    private IBlockRepository blockRepository;
    @Autowired
    private BlockMapper blockMapper;
    public BlockDto addNewBlock(BlockDto dto) {
        blockRepository.save(blockMapper.convertToEntity(dto));
        return dto;
    }

    public List<GetBlockDto> getAllBlock(){
        return blockMapper.convertToListDto(blockRepository.findAll());
    }

    public BlockDetailDto getBlockDetail(Long blockId) {
        List<Object[]> rows = blockRepository.getBlockDetailRaw(blockId);
        if (rows.isEmpty()) return null;
        Map<Long, GetFloorDto> floorMap = new LinkedHashMap<>();
        Long blockIdResult = null;
        String blockName = null;
        for (Object[] row : rows) {
            blockIdResult = ((Number) row[0]).longValue();
            blockName = (String) row[1];
            Long floorId = ((Number) row[2]).longValue();
            String floorName = (String) row[3];
            Integer level = (Integer) row[4];
            Long roomId = ((Number) row[5]).longValue();
            String roomName = (String) row[6];
            Long deviceId = row[7] != null ? ((Number) row[7]).longValue() : null;
            String deviceName = (String) row[8];
            Integer quantity = row[9] != null ? ((Number) row[9]).intValue() : 0;
            GetFloorDto floorDto = floorMap.computeIfAbsent(floorId, id ->
                    new GetFloorDto(id, floorName, level, new ArrayList<>())
            );
            Optional<GetRoomDto> roomOpt = floorDto.getRooms().stream()
                    .filter(r -> r.getRoomId().equals(roomId))
                    .findFirst();
            GetRoomDto roomDto;
            if (roomOpt.isPresent()) {
                roomDto = roomOpt.get();
            } else {
                roomDto = new GetRoomDto(roomId, roomName, new ArrayList<>());
                floorDto.getRooms().add(roomDto);
            }
            if (deviceId != null) {
                roomDto.getDevices().add(
                        new GetDeviceDto(deviceId, deviceName, quantity)
                );
            }
        }
        return new BlockDetailDto(blockIdResult, blockName, new ArrayList<>(floorMap.values()));
    }
}
