package com.example.RoomManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "device_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private String name;
    private Boolean online;

    private Long activeTime;
    private Long updateTime;

    private Long createdAt;
}
