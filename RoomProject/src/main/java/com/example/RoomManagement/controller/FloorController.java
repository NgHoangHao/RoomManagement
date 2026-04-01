package com.example.RoomManagement.controller;

import com.example.RoomManagement.dto.request.FloorDto;
import com.example.RoomManagement.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FloorController {
    @Autowired
    private FloorService floorService;

    @PostMapping("/add-floor")
    public ResponseEntity<FloorDto> addFloor(@RequestBody FloorDto floorDto) {
        FloorDto floor = floorService.addNewFloor(floorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(floor);
    }
}
