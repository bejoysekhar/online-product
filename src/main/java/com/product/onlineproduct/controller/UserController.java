package com.product.onlineproduct.controller;

import com.product.onlineproduct.entity.Product;
import com.product.onlineproduct.entity.User;
import com.product.onlineproduct.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveProduct(@RequestBody User user){
        User u = userService.createUser(user);
        URI uri = URI.create("/product/" + u.getId());
        return ResponseEntity.created(uri).body(u);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProduct(@PathVariable Long id){
        userService.deleteProduct(id);
    }

}
