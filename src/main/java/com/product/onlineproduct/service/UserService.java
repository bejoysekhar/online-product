package com.product.onlineproduct.service;

import com.product.onlineproduct.dto.UserDto;
import com.product.onlineproduct.entity.Cart;
import com.product.onlineproduct.entity.User;
import com.product.onlineproduct.exception.GenericException;
import com.product.onlineproduct.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public UserDto getUser(Long id) throws GenericException {
        User user = userRepository.findById(id).orElseThrow(() -> new GenericException("User Not Found"));
        UserDto userDto = new UserDto(user.getId(), user.getName());
        return userDto;
    }

    public UserDto createUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        Cart cart = new Cart();
        user.setCart(cart);

        User u = userRepository.save(user);
        UserDto userDto1 = new UserDto(u.getId(), u.getName());
        return userDto1;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
