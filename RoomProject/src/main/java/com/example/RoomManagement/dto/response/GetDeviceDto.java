package com.example.RoomManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDeviceDto {
    private Long deviceId;
    private String deviceName;
    private int quantity;
}
