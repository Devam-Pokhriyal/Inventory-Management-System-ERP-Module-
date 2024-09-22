package com.example.demo.Entity;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class VendorItemMappingId implements Serializable {
    private String code;
    private String itemCode;

    // Default constructor
    public VendorItemMappingId() {}

    // Parameterized constructor
    public VendorItemMappingId(String code, String itemCode) {
        this.code = code;
        this.itemCode = itemCode;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorItemMappingId that = (VendorItemMappingId) o;
        return Objects.equals(code, that.code) && Objects.equals(itemCode, that.itemCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, itemCode);
    }
}
