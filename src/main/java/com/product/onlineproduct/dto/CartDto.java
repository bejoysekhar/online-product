package com.product.onlineproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartDto {

    private Long userId;
    private List<ItemDto> itemDtoList = new ArrayList<>();
}
