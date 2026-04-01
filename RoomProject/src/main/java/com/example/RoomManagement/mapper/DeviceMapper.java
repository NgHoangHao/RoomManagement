package com.example.RoomManagement.mapper;

import com.example.RoomManagement.dto.request.DeviceDto;
import com.example.RoomManagement.model.Category;
import com.example.RoomManagement.model.Device;
import com.example.RoomManagement.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {
    @Autowired
    private ICategoryRepository categoryRepository;
    public Device convertToEntity(DeviceDto deviceDto) {
        Device device = new Device();
        device.setName(deviceDto.getName());
        Category category = categoryRepository.findById(deviceDto.getCategoryId()).orElseThrow(()->new RuntimeException("Floor not found"));
        device.setCategory(category);
        return device;
    }
}
