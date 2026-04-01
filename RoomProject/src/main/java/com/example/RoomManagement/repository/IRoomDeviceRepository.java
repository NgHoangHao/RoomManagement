package com.example.RoomManagement.repository;

import com.example.RoomManagement.model.RoomDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomDeviceRepository extends JpaRepository<RoomDevice, Long> {
    public RoomDevice findByRoomIdAndDeviceId(Long roomId, Long deviceId);
}
