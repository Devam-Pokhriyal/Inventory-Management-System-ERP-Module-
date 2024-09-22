package com.example.demo.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "trn_detail")
public class TrnDetails {

    @EmbeddedId
    private TrnDetailsId id;

    private String itemCode;
    private String itemDesc;
    private String fromUom;
    private String toUom;
    private BigDecimal itemQty;
    private BigDecimal itemRate;
    private String fromLocation;
    private String ToLocation;
    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return ToLocation;
    }

    public void setToLocation(String toLocation) {
        ToLocation = toLocation;
    }

    // Getters and Setters
    public TrnDetailsId getId() {
        return id;
    }

    public void setId(TrnDetailsId id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getFromUom() {
        return fromUom;
    }

    public void setFromUom(String fromUom) {
        this.fromUom = fromUom;
    }

    public String getToUom() {
        return toUom;
    }

    public void setToUom(String toUom) {
        this.toUom = toUom;
    }

    public BigDecimal getItemQty() {
        return itemQty;
    }

    public void setItemQty(BigDecimal itemQty) {
        this.itemQty = itemQty;
    }

    public BigDecimal getItemRate() {
        return itemRate;
    }

    public void setItemRate(BigDecimal itemRate) {
        this.itemRate = itemRate;
    }
}
