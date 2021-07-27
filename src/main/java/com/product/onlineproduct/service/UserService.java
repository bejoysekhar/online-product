package com.product.onlineproduct.service;

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

    public User getUser(Long id) throws ProductNotFoundException{
        User user = userRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("User Not Found"));
        log.info("User: {}", user);
        return user;
    }

    public User createUser(User user){
        User u = userRepository.save(user);
        log.info("User: {}", u);
        return u;
    }

    public void deleteProduct(Long id){
        userRepository.deleteById(id);
    }

}
