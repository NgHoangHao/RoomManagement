package com.example.RoomManagement.dto.request;

import com.example.RoomManagement.model.Device;
import com.example.RoomManagement.model.Room;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDeviceRequest {
    private Long roomId;
    private Long deviceId;
    private int quantity;
    private String status;
}
