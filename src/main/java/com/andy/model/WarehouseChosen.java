package com.andy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.beans.Transient;

/**
 * Created by Andy on 02/04/2015.
 */

@Entity
public class WarehouseChosen {

    @Id
    private Long id;

    private Long warehouseId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}
