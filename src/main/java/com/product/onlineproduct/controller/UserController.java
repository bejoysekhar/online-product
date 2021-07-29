package com.product.onlineproduct.controller;

import com.product.onlineproduct.dto.UserDto;
import com.product.onlineproduct.entity.User;
import com.product.onlineproduct.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping(value = "/user/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        UserDto u = userService.createUser(userDto);
        URI uri = URI.create("/user/" + u.getId());
        return ResponseEntity.created(uri).body(u);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
