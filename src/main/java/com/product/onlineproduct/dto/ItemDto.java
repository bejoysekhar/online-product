package com.product.onlineproduct.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ItemDto {

    private Long itemId;
    private Long productId;
    private Integer quantity;

}
