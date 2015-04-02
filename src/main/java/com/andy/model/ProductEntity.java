package com.andy.model;

import javax.persistence.*;


@Entity
@Table(name = "product", schema = "", catalog = "wholesaledeliverysystem")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "itemDescription")
    private String itemDescription;

    @Column(name = "itemWeight")
    private int itemWeight;

    @Column(name = "itemPrice")
    private int itemPrice;

    @Column(name = "itemStatus")
    private boolean itemStatus;

    @Column(name = "imageurl")
    private String imageurl;

    @Column(name = "totalStock")
    private int totalStock;

    @OneToOne
    StockEntity stockEntity;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Basic
    @Column(name = "itemDescription")
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Basic
    @Column(name = "itemWeight")
    public int getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    public boolean isItemStatus() {
        return itemStatus;
    }

    @Basic
    @Column(name = "itemStatus")
    public boolean getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(boolean itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (itemId != that.itemId) return false;
        if (itemPrice != that.itemPrice) return false;
        if (itemWeight != that.itemWeight) return false;
        if (itemDescription != null ? !itemDescription.equals(that.itemDescription) : that.itemDescription != null)
            return false;

        return true;
    }

    public StockEntity getStockEntity() {
        return stockEntity;
    }

    public void setStockEntity(StockEntity stockEntity) {
        this.stockEntity = stockEntity;
    }
}
