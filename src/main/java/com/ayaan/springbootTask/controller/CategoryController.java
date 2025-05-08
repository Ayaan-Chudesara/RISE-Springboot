package com.ayaan.springbootTask.controller;

import com.ayaan.springbootTask.dto.CategoryDTO;
import com.ayaan.springbootTask.entity.Category;
import com.ayaan.springbootTask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService CategoryService;

    @GetMapping("/all")
    private ResponseEntity<List<CategoryDTO>> getAllCategorys(){
        try{
            return ResponseEntity.ok(CategoryService.getAllCategories());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<CategoryDTO> getCategoryById( @PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(CategoryService.getCategoryById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/")
    private ResponseEntity<CategoryDTO> updateCategory(@RequestBody Category Category){
        try{
            return ResponseEntity.ok(CategoryService.updateCategory(Category));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    private ResponseEntity<CategoryDTO> saveCategory(@RequestBody Category Category){
        try{
            return ResponseEntity.ok(CategoryService.saveCategory(Category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/")
    private ResponseEntity<Void> deleteCategory(@RequestBody Category Category){
        try{
            CategoryService.deleteCategory(Category);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
