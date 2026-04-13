package com.example.RoomManagement.repository;

import com.example.RoomManagement.model.DeviceData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceDataRepository extends JpaRepository<DeviceData, Long> {
}
