package com.ayaan.springbootTask.service;

import com.ayaan.springbootTask.dto.ProductDTO;
import com.ayaan.springbootTask.entity.Product;

import java.util.List;

public interface ProductService {
     List<ProductDTO> getAllProducts();
     ProductDTO getProductById(Long id);
     ProductDTO saveProduct(Product product);
     ProductDTO updateProduct(Product product);
     void deleteProduct(Product product);
}
