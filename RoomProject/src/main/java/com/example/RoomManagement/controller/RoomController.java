package com.example.RoomManagement.controller;

import com.example.RoomManagement.dto.request.RoomDto;
import com.example.RoomManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/add-room")
    public ResponseEntity<RoomDto> addRoom(@RequestBody RoomDto roomDto) {
        RoomDto room = roomService.addNewRoom(roomDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
}
