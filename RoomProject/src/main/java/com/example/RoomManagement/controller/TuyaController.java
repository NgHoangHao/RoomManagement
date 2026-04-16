package com.example.RoomManagement.controller;

import com.example.RoomManagement.dto.response.TuyaDeviceResponse;
import com.example.RoomManagement.dto.response.TuyaLogsResponseDTO;
import com.example.RoomManagement.service.TuyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/logs")
    public ResponseEntity<TuyaLogsResponseDTO> getLogs(
            @RequestParam String deviceId,
            @RequestParam String codes,
            @RequestParam long startTime,
            @RequestParam long endTime,
            @RequestParam(defaultValue = "100") int size,
            @RequestParam(required = false) String lastRowKey
    ) {
        return ResponseEntity.ok(
                tuyaService.getDeviceLogs(deviceId, codes, startTime, endTime, size, lastRowKey)
        );
    }
}