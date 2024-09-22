package com.example.demo.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor_item_mapping")
public class VendorItemMapping {

    @EmbeddedId
    private VendorItemMappingId id;

    // Default constructor
    public VendorItemMapping() {}

    // Parameterized constructor
    public VendorItemMapping(VendorItemMappingId id) {
        this.id = id;
    }

    // Getters and Setters
    public VendorItemMappingId getId() {
        return id;
    }

    public void setId(VendorItemMappingId id) {
        this.id = id;
    }
}
