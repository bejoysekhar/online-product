package com.product.onlineproduct.service;

import com.product.onlineproduct.dto.CartDto;
import com.product.onlineproduct.dto.ItemDto;
import com.product.onlineproduct.entity.Item;
import com.product.onlineproduct.entity.User;
import com.product.onlineproduct.exception.GenericException;
import com.product.onlineproduct.repository.ItemRepository;
import com.product.onlineproduct.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class CartService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private UserRepository userRepository;
    private ItemRepository itemRepository;

    public CartService(UserRepository userRepository, ItemRepository itemRepository){
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public CartDto getCart(Long userId) throws GenericException {
        User user = userRepository.findById(userId).orElseThrow(() -> new GenericException("User Not Found"));
        Set<Item> items = user.getCart().getItems();
        CartDto cartDto = new CartDto();
        cartDto.setUserId(userId);
        items.forEach(e -> cartDto.getItemDtoList().add(new ItemDto(e.getId(), e.getProductId(),e.getQuantity())));
        return cartDto;
    }

    @Transactional
    public List<Item> addItemsToCart(CartDto cartDto)throws GenericException{
        User user = userRepository.findById(cartDto.getUserId()).orElseThrow(() -> new GenericException("No user foound"));
        Set<Item> itemsInCart = user.getCart().getItems();

        Set<Item> newItems = new HashSet<>();
        cartDto.getItemDtoList().stream().forEach(e -> newItems.add(new Item(e.getProductId(), e.getQuantity(), user.getCart())));

        Map<Long, Item> inCartMap  = itemsInCart.stream().collect(Collectors.toMap(e -> e.getProductId(), e -> e));

        Set<Item> itemsToSave = new HashSet<>();

        newItems.stream().forEach(e -> {
            Item item=null;
            if((item = inCartMap.get(e.getProductId())) != null){

                itemsToSave.add(new Item(item.getId(), e.getProductId(),e.getQuantity() + item.getQuantity(), user.getCart() ));
            }else{
                itemsToSave.add(new Item(e.getProductId(),e.getQuantity(), user.getCart() ));
            }
        });

        Iterable<Item> items = itemRepository.saveAll(itemsToSave);

        return StreamSupport.stream(items.spliterator(), false).collect(Collectors.toList());
    }

    @Transactional
    public void deleteItemsFromCart(Long itemId){
        itemRepository.deleteById(itemId);

    }

}
