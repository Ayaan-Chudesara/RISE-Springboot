package com.ayaan.springbootTask.service.Impl;

import com.ayaan.springbootTask.dto.CategoryDTO;
import com.ayaan.springbootTask.entity.Category;
import com.ayaan.springbootTask.repo.CategoryRepo;
import com.ayaan.springbootTask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo CategoryRepo;


    public List<CategoryDTO> getAllCategories(){
        List<Category> categoryList = CategoryRepo.findAll();
        List<CategoryDTO> categories = new ArrayList<>();

        for(Category category:categoryList){
            CategoryDTO dto = this.mapCategorytoDTO(category);
            categories.add(dto);
        }
        return categories;
    }

    public CategoryDTO getCategoryById(Long id){
        Optional<Category> categoryOptional = CategoryRepo.findById(id);
        if(categoryOptional.isPresent()){
            return this.mapCategorytoDTO(categoryOptional.get());
        }else{
            return null;
        }
    }

    public CategoryDTO saveCategory(Category category){
        Category savedCategory = CategoryRepo.save(category);
        return this.mapCategorytoDTO(savedCategory);
    }

    public CategoryDTO updateCategory(Category category){
        Category updatedCategory = CategoryRepo.save(category);
        return this.mapCategorytoDTO(updatedCategory);
    }

    public void deleteCategory(Category category){
        CategoryRepo.delete(category);

    }

    private CategoryDTO mapCategorytoDTO(Category category){ {
        CategoryDTO catagoryDTO = new CategoryDTO();
        catagoryDTO.setId(category.getId());
        catagoryDTO.setName(category.getName());
        catagoryDTO.setDescription(category.getDescription());
        catagoryDTO.setType(category.getType());
        return catagoryDTO;
    }
}}
