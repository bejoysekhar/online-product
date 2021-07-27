package com.product.onlineproduct.service;

import com.product.onlineproduct.dto.UserDto;
import com.product.onlineproduct.entity.User;
import com.product.onlineproduct.exception.ProductNotFoundException;
import com.product.onlineproduct.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto getUser(Long id) throws ProductNotFoundException{
        User user = userRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("User Not Found"));
        UserDto userDto = new UserDto(user.getId(), user.getName());
        log.info("User: {}", user);
        return userDto;
    }

    public UserDto createUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        User u = userRepository.save(user);
        UserDto userDto1 = new UserDto(u.getId(), u.getName());
        log.info("User: {}", u);
        return userDto1;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
