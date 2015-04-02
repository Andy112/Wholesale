package com.andy.model.cart;

import com.andy.model.ProductEntity;

import javax.persistence.*;

/**
 * Created by Andy on 28/03/2015.
 */
@Entity
@Table(name = "product", schema = "", catalog = "wholesaledeliverysystem")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @OneToOne
    private ProductEntity product;

    private int qty;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
