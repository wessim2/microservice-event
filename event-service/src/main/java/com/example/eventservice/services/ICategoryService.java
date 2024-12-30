package com.example.eventservice.services;

import com.example.eventservice.entities.Category;

import java.util.List;

public interface ICategoryService {
    public Category addCategory(Category category);
    public List<Category> getAllCategories();
}
