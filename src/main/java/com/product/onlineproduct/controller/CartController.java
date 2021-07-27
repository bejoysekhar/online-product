package com.product.onlineproduct.controller;

import com.product.onlineproduct.dto.CartDto;
import com.product.onlineproduct.dto.UserDto;
import com.product.onlineproduct.entity.Item;
import com.product.onlineproduct.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

//    @GetMapping(value = "/user/{id}", produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
//        return ResponseEntity.ok(userService.getUser(id));
//    }

    @PostMapping("/cart")
    public ResponseEntity<Iterable<Item>> addItemsToCart(@RequestBody CartDto cartDto){
        Iterable<Item> items = cartService.addItemsToCart(cartDto);
        return ResponseEntity.ok().body(items);
    }

//    @DeleteMapping("/user/{id}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public void deleteUser(@PathVariable Long id){
//        userService.deleteUser(id);
//    }

}
