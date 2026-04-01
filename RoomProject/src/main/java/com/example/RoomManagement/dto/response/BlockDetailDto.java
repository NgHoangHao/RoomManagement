package com.example.RoomManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlockDetailDto {
    private Long blockId;
    private String blockName;
    private List<GetFloorDto> floors;
}