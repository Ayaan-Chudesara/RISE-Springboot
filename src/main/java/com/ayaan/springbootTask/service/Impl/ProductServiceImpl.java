package com.ayaan.springbootTask.service.Impl;

import com.ayaan.springbootTask.dto.ProductDTO;
import com.ayaan.springbootTask.entity.Product;
import com.ayaan.springbootTask.repo.ProductRepo;
import com.ayaan.springbootTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo ProductRepo;

    @Override
    public List<ProductDTO> getAllProducts(){
      List<Product> productList = ProductRepo.findAll();
      List<ProductDTO> products = new ArrayList<>();

      for(Product product:productList){
          ProductDTO dto = this.mapProducttoDTO(product);
          products.add(dto);
      }
      return products;
    }

    public ProductDTO getProductById(Long id){
        Optional<Product> productOptional = ProductRepo.findById(id);
        if(productOptional.isPresent()){
            return this.mapProducttoDTO(productOptional.get());
        }else{
            return null;
        }
    }

    public ProductDTO saveProduct(Product product){
        Product savedProduct = ProductRepo.save(product);
        return this.mapProducttoDTO(savedProduct);
    }

    public ProductDTO updateProduct(Product product){
        Product updatedProduct = ProductRepo.save(product);
        return this.mapProducttoDTO(updatedProduct);
    }

    public void deleteProduct(Product product){
        ProductRepo.delete(product);

    }

    private ProductDTO mapProducttoDTO(Product product) {
ProductDTO productDTO = new ProductDTO();
   productDTO.setId(product.getId());
   productDTO.setName(product.getName());
   productDTO.setPrice(product.getPrice());
   productDTO.setBrand(product.getBrand());
   return productDTO;
    }

}
