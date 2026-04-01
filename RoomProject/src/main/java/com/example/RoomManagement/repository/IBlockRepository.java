package com.example.RoomManagement.repository;

import com.example.RoomManagement.model.Block;
import com.example.RoomManagement.model.RoomDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlockRepository extends JpaRepository<Block, Long> {
    @Query(value = """
    SELECT 
        b.id as block_id,
        b.name as block_name,

        f.id as floor_id,
        f.floor_name,
        f.level,

        r.id as room_id,
        r.name as room_name,

        d.id as device_id,
        d.name as device_name,

        rd.quantity

    FROM blocks b
    JOIN floors f ON f.block_id = b.id
    JOIN rooms r ON r.floor_id = f.id
    LEFT JOIN room_devices rd ON rd.room_id = r.id
    LEFT JOIN devices d ON d.id = rd.device_id

    WHERE b.id = :blockId
    ORDER BY f.level ASC
""", nativeQuery = true)
    List<Object[]> getBlockDetailRaw(Long blockId);
}
