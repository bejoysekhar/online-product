package com.product.onlineproduct.service;

import com.product.onlineproduct.entity.Product;
import com.product.onlineproduct.exception.GenericException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void getProductTest(){
        Product p = productService.getProduct(1L);
        assertEquals(1L, p.getId());
        assertEquals("Product 1", p.getName());
        assertEquals("Product 1 description", p.getDescription());
    }

    @Test
    public void createProductTest(){
        String productName = "New Test Product";
        String productDesc = "New Test Product Description";
        Product p = new Product();
        p.setName(productName);
        p.setDescription(productDesc);
        Product result = productService.createProduct(p);
        assertEquals(productName, result.getName());
        assertEquals(productDesc, result.getDescription());
    }


    @Test
    public void deleteProductTest(){
        Product p = productService.getProduct(1L);
        assertNotNull(p);
        productService.deleteProduct(1L);
        assertThrows(GenericException.class, () ->  productService.getProduct(1L));

    }


}
