package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class StockId implements Serializable {

    private Date financialYear;
    private String location;
    private String itemCode;

    // Default constructor
    public StockId() {}

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

    // hashCode and equals methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return Objects.equals(financialYear, stockId.financialYear) &&
               Objects.equals(location, stockId.location) &&
               Objects.equals(itemCode, stockId.itemCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(financialYear, location, itemCode);
    }
}
