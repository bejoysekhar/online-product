package com.product.onlineproduct.service;

import com.product.onlineproduct.dto.CartDto;
import com.product.onlineproduct.dto.ItemDto;
import com.product.onlineproduct.dto.UserDto;
import com.product.onlineproduct.entity.Item;
import com.product.onlineproduct.exception.GenericException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext
public class CartServiceTest {

    @Autowired
    CartService cartService;

    @Test
    public void getCartTest(){
        CartDto cart = cartService.getCart(1L);
        List<ItemDto> list = new ArrayList<>();
        list.add(new ItemDto(1L, 1));
        list.add(new ItemDto(2L, 2));
        assertEquals(1L, cart.getUserId());
        cart.getItemDtoList().sort(Comparator.comparing(ItemDto::getProductId).thenComparing(ItemDto::getQuantity));
        assertEquals(list, cart.getItemDtoList());

    }

    @Test
    public void addItemsToCartTest(){
        CartDto cartDto = new CartDto();
        cartDto.setUserId(5L);
        List<ItemDto> itemDtos = new ArrayList<>();
        itemDtos.add(new ItemDto(1L, 1));
        itemDtos.add(new ItemDto(2L, 2));
        cartDto.setItemDtoList(itemDtos);

        List<Item> itemsResponse = cartService.addItemsToCart(cartDto);
        itemsResponse.sort(Comparator.comparing(Item::getProductId).thenComparing(Item::getQuantity));
        assertEquals(itemDtos.size(), itemsResponse.size());
        assertEquals(itemDtos.get(0).getProductId(), itemsResponse.get(0).getProductId());
        assertEquals(itemDtos.get(0).getQuantity(), itemsResponse.get(0).getQuantity());
        assertEquals(itemDtos.get(1).getProductId(), itemsResponse.get(1).getProductId());
        assertEquals(itemDtos.get(1).getQuantity(), itemsResponse.get(1).getQuantity());


    }

}
