package com.example.eventservice.services;

import com.example.eventservice.entities.Category;
import com.example.eventservice.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private final CategoryRepository _categoryRepository;

    @Override
    public Category addCategory(Category category) {
       Category existingCategory = _categoryRepository.findByName(category.getName());

       if (existingCategory != null) {
           return null;
       }

       return _categoryRepository.save(category);
    }
    @Override
    public List<Category> getAllCategories() {
        return _categoryRepository.findAll();
    }
}
