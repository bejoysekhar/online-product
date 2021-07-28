package com.product.onlineproduct.controller;

import com.product.onlineproduct.dto.CartDto;
import com.product.onlineproduct.entity.Item;
import com.product.onlineproduct.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping(value = "/cart", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDto> getCart(@RequestParam Long userId){
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @PostMapping("/cart")
    public ResponseEntity<List<Item>> addItemsToCart(@RequestBody CartDto cartDto){
        List<Item> items = cartService.addItemsToCart(cartDto);
        return ResponseEntity.ok().body(items);
    }

    @DeleteMapping("/cart/item/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteItemsFromCart(@PathVariable Long id){
        cartService.deleteItemsFromCart(id);
    }

}
