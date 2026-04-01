package com.example.RoomManagement.controller;

import com.example.RoomManagement.dto.request.DeviceDto;
import com.example.RoomManagement.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {
   @Autowired
    private DeviceService deviceService;

   @PostMapping("/add-device")
    public ResponseEntity<DeviceDto> addDevice(@RequestBody DeviceDto deviceDto) {
       DeviceDto device = deviceService.addNewDevice(deviceDto);
       return ResponseEntity.status(HttpStatus.CREATED).body(device);
   }
}
