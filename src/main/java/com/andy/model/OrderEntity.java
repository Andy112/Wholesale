package com.andy.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "order", schema = "", catalog = "wholesaledeliverysystem")
public class OrderEntity {

    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Basic
    @Column(name = "orderDate")
    private Date orderDate;
    @Basic
    @Column(name = "orderStatus")
    private String orderStatus;

    @OneToMany
    private List<OrderItem> orderItems;
    @Basic
    @Column(name = "orderQuantity")
    private int orderQuantity;

    @OneToOne
            @JoinColumn(name = "customer_id", referencedColumnName = "customer_id" )
    Customer customer;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
