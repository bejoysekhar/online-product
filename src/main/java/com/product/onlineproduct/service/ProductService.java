package com.product.onlineproduct.service;

import com.product.onlineproduct.dto.ProductDto;
import com.product.onlineproduct.entity.Product;
import com.product.onlineproduct.exception.ProductNotFoundException;
import com.product.onlineproduct.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductDto getProduct(Long id) throws ProductNotFoundException{
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        return productDto;
    }

    public void createProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());

        productRepository.save(product);
    }
}
