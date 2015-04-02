package com.andy.model;

import javax.persistence.*;


@Entity
@Table(name = "warehouse", schema = "", catalog = "wholesaledeliverysystem")
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "warehouseId")
    private Long warehouseId;

    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "address")
    private String address;



    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
