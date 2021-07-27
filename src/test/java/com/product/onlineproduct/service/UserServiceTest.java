package com.product.onlineproduct.service;

import com.product.onlineproduct.dto.UserDto;
import com.product.onlineproduct.entity.Product;
import com.product.onlineproduct.entity.User;
import com.product.onlineproduct.exception.GenericException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void getUserTest(){
        UserDto u = userService.getUser(1L);
        assertEquals(1L, u.getId());
        assertEquals("Name1", u.getName());
    }

    @Test
    public void createUserTest(){
        String userName = "New Test Name";
        UserDto userDto = new UserDto();
        userDto.setName(userName);
        UserDto result = userService.createUser(userDto);
        assertEquals(userName, result.getName());
    }


    @Test
    public void deleteUserTest(){
        UserDto userDto = userService.getUser(1L);
        assertNotNull(userDto);
        userService.deleteUser(1L);
        assertThrows(GenericException.class, () ->  userService.getUser(1L));

    }


}
