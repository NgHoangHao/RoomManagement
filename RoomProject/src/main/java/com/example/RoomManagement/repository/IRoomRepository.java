package com.example.RoomManagement.repository;

import com.example.RoomManagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Long> {
    @Query("""
    SELECT DISTINCT r FROM Room r
    LEFT JOIN FETCH r.roomDevices rd
    LEFT JOIN FETCH rd.device
""")
    List<Room> findAllWithDevices();
}
