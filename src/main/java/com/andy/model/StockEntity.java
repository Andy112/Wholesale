package com.andy.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "stock", schema = "", catalog = "wholesaledeliverysystem")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockId;

    @Basic
    @Column(name = "stockDescription")
    private String stockDescription;

    @Basic
    @Column(name = "stockStatus")
    private String stockStatus;

    @Basic
    @Column(name = "stockLevel")
    private int stockLevel;

    @OneToMany
        @JoinTable
    List<WarehouseEntity> warehouseEntity;


    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }


    public String getStockDescription() {
        return stockDescription;
    }

    public void setStockDescription(String stockDescription) {
        this.stockDescription = stockDescription;
    }


    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }


    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public List<WarehouseEntity> getWarehouseEntity() {
        return warehouseEntity;
    }

    public void setWarehouseEntity(List<WarehouseEntity> warehouseEntity) {
        this.warehouseEntity = warehouseEntity;
    }
}
