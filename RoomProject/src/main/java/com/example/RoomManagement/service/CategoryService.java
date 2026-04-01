package com.example.RoomManagement.service;

import com.example.RoomManagement.dto.request.CategoryDto;
import com.example.RoomManagement.mapper.CategoryMapper;
import com.example.RoomManagement.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    public CategoryDto addNewCategory(CategoryDto dto) {
        categoryRepository.save(categoryMapper.convertToEntity(dto));
        return dto;
    }
}
