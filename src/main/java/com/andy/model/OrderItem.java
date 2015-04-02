package com.andy.model;

import javax.persistence.*;

@Entity
@Table (name = "order_line")
public class OrderItem {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @OneToOne
    private ProductEntity product;

    private int qty;

    @OneToOne
    private OrderEntity orderentity;

    @OneToOne
    private WarehouseEntity warehouse;

    private int transferId;

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

    public WarehouseEntity getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseEntity warehouse) {
        this.warehouse = warehouse;
    }

    public OrderEntity getOrderentity() {
        return orderentity;
    }

    public void setOrderentity(OrderEntity orderentity) {
        this.orderentity = orderentity;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }
}
