package com.product.onlineproduct.service;

import com.product.onlineproduct.entity.Product;
import com.product.onlineproduct.exception.ProductNotFoundException;
import com.product.onlineproduct.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id) throws ProductNotFoundException{
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
        log.info("Product: {}", product);
        return product;
    }

    public Product createProduct(Product product){
        Product p = productRepository.save(product);
        log.info("Product: {}", p);
        return p;
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
