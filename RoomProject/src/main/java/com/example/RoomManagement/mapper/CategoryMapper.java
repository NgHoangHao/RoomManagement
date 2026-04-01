package com.example.RoomManagement.mapper;

import com.example.RoomManagement.dto.request.CategoryDto;
import com.example.RoomManagement.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category convertToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }
}
