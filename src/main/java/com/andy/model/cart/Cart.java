package com.andy.model.cart;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andy on 28/03/2015.
 */
@Entity
@Table(name = "product", schema = "", catalog = "wholesaledeliverysystem")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;


    @OneToMany
    private List<CartItem> cartItems;


    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }


}
