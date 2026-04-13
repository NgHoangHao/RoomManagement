package com.example.RoomManagement.controller;

import com.example.RoomManagement.dto.response.TuyaDeviceResponse;
import com.example.RoomManagement.service.TuyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tuya")
@RequiredArgsConstructor
public class TuyaController {

    private final TuyaService tuyaService;

    @GetMapping("/device/{id}")
    public TuyaDeviceResponse getDevice(@PathVariable String id) {
        return tuyaService.getDevice(id);
    }
}