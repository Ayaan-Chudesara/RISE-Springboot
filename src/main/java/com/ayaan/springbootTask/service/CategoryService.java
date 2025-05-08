package com.ayaan.springbootTask.service;

import com.ayaan.springbootTask.dto.CategoryDTO;
import com.ayaan.springbootTask.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Long id);
    CategoryDTO saveCategory(Category category);
    CategoryDTO updateCategory(Category category);
    void deleteCategory(Category category);

}
