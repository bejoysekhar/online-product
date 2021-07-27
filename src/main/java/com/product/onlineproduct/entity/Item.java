package com.product.onlineproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode()
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    private Long productId;

    @EqualsAndHashCode.Exclude
    private Integer quantity;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Cart cart;

    public Item(){
    }
    public Item(Long productId, Integer quantity, Cart cart){
        this.productId = productId;
        this.quantity = quantity;
        this.cart = cart;
    }
    public Item(Long id, Long productId, Integer quantity, Cart cart){
        this.id =id;
        this.productId = productId;
        this.quantity = quantity;
        this.cart = cart;
    }

}
