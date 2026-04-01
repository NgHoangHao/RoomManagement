package com.example.RoomManagement.controller;

import com.example.RoomManagement.dto.request.DeleteDeviceRequest;
import com.example.RoomManagement.dto.request.RoomDeviceRequest;
import com.example.RoomManagement.dto.request.UpdateDeviceRequest;
import com.example.RoomManagement.service.RoomDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomDeviceController {
    @Autowired
    private RoomDeviceService roomDeviceService;

    @PostMapping("/add-roomdevice")
    public ResponseEntity<RoomDeviceRequest> addRoomDevice(@RequestBody RoomDeviceRequest roomDeviceRequest) {
        RoomDeviceRequest roomDevice = roomDeviceService.addNewRoomDevice(roomDeviceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(roomDevice);
    }

    @PutMapping("update-device-in-room")
    public ResponseEntity<UpdateDeviceRequest> updateRoomDevice(@RequestBody UpdateDeviceRequest updateDeviceRequest) {
        return ResponseEntity.ok(roomDeviceService.updateRoomDevice(updateDeviceRequest));
    }

    @DeleteMapping("delete-devide-from-room")
    public ResponseEntity<String> deleteRoomDevice(@RequestBody DeleteDeviceRequest deleteDeviceRequest) {
        return  ResponseEntity.ok(roomDeviceService.deleteRoomDevice(deleteDeviceRequest));
    }
}
