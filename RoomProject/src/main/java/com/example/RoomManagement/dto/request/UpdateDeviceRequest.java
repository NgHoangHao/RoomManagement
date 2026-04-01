package com.example.RoomManagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDeviceRequest {
    private Long roomId;
    private Long deviceId;
    private int quantity;
}
