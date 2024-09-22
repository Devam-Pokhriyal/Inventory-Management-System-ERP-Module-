package com.example.demo.Entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
@IdClass(StockId.class)
public class Stock {

    @Id
    @Column(name = "FinancialYear")
    private Date financialYear;

    @Id
    @Column(name = "Location")
    private String location;

    @Id
    @Column(name = "ItemCode")
    private String itemCode;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    // Getters and Setters
    public Date getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(Date financialYear) {
        this.financialYear = financialYear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
