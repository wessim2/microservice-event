package com.example.eventservice.services.impl;

import com.example.eventservice.dto.categoryDto.CategoryDto;
import com.example.eventservice.entities.Category;
import com.example.eventservice.exceptions.category.CategoryAlreadyExistsException;
import com.example.eventservice.mapper.category.CategoryMapper;
import com.example.eventservice.repositories.CategoryRepository;
import com.example.eventservice.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository _categoryRepository;

    @Override
    public Category addCategory(CategoryDto categoryDto) {
       Optional<Category> existingCategory = _categoryRepository.findByName(categoryDto.getName());

       if (existingCategory.isPresent()) {
           throw new CategoryAlreadyExistsException("Category Already exists");
       }

       Category category = CategoryMapper.mapToCategory(categoryDto);

       return _categoryRepository.save(category);
    }
    @Override
    public List<Category> getAllCategories() {
        return _categoryRepository.findAll();
    }
}
