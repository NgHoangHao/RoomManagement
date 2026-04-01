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
public class GetFloorDto {
    private Long floorId;
    private String floorName;
    private Integer level;
    private List<GetRoomDto> rooms;
}
