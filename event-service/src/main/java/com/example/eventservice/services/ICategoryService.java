package com.example.eventservice.services;

import com.example.eventservice.dto.categoryDto.CategoryDto;
import com.example.eventservice.entities.Category;

import java.util.List;

public interface ICategoryService {
    public Category addCategory(CategoryDto category);
    public List<Category> getAllCategories();
}
