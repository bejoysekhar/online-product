package com.product.onlineproduct.controller;

import com.product.onlineproduct.entity.Product;
import com.product.onlineproduct.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/products", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @GetMapping(value = "/product/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product p = productService.createProduct(product);
        URI uri = URI.create("/product/" + p.getId());
        return ResponseEntity.created(uri).body(p);
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
