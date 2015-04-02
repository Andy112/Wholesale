package com.andy.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "transfer", schema = "", catalog = "wholesaledeliverysystem")
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transferId;
    private Date transferDate;
    private String transferDeparture;
    private String transferDestination;
    private int milage;

    @Id
    @Column(name = "transferId")
    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    @Basic
    @Column(name = "transferDate")
    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    @Basic
    @Column(name = "transferDeparture")
    public String getTransferDeparture() {
        return transferDeparture;
    }

    public void setTransferDeparture(String transferDeparture) {
        this.transferDeparture = transferDeparture;
    }

    @Basic
    @Column(name = "transferDestination")
    public String getTransferDestination() {
        return transferDestination;
    }

    public void setTransferDestination(String transferDestination) {
        this.transferDestination = transferDestination;
    }

    @Basic
    @Column(name = "milage")
    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransferEntity that = (TransferEntity) o;

        if (milage != that.milage) return false;
        if (transferId != that.transferId) return false;
        if (transferDate != null ? !transferDate.equals(that.transferDate) : that.transferDate != null) return false;
        if (transferDeparture != null ? !transferDeparture.equals(that.transferDeparture) : that.transferDeparture != null)
            return false;
        if (transferDestination != null ? !transferDestination.equals(that.transferDestination) : that.transferDestination != null)
            return false;

        return true;
    }


}
