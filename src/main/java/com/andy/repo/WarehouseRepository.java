package com.andy.repo;


import com.andy.model.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {
}