package com.example.RoomManagement.repository;

import com.example.RoomManagement.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFloorRepository extends JpaRepository<Floor, Long> {
}
