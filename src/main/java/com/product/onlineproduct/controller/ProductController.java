package com.product.onlineproduct.controller;

import com.product.onlineproduct.dto.ProductDto;
import com.product.onlineproduct.entity.Product;
import com.product.onlineproduct.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping("/prodcut")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
    }
}
