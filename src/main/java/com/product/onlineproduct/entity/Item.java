package com.product.onlineproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
