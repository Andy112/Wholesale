package com.andy.repo;



import com.andy.model.OrderEntity;
import com.andy.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}