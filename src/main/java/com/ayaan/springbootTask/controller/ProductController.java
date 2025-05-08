package com.ayaan.springbootTask.controller;

import com.ayaan.springbootTask.dto.ProductDTO;
import com.ayaan.springbootTask.entity.Product;
import com.ayaan.springbootTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.awt.image.ReplicateScaleFilter;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    private ResponseEntity<List<ProductDTO>> getAllProducts(){
        try{
        return ResponseEntity.ok(productService.getAllProducts());
    }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
}

   @GetMapping("/{id}")
    private ResponseEntity<ProductDTO> getProductById( @PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(productService.getProductById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/")
    private ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product){
        try{
            return ResponseEntity.ok(productService.updateProduct(product));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    private ResponseEntity<ProductDTO> saveProduct(@RequestBody Product product){
        try{
            return ResponseEntity.ok(productService.saveProduct(product));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/")
    private ResponseEntity<Void> deleteProduct(@RequestBody Product product){
        try{
            productService.deleteProduct(product);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
            }


