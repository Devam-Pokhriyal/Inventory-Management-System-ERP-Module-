package com.example.demo.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_uom_conversion")
public class ItemUOMaster {

    @EmbeddedId
    private ItemUOMasterId id;

    private String cf;
    private String rcf;
 private String UomValue;

    public String getUomValue() {
    return UomValue;
}


public void setUomValue(String uomValue) {
    UomValue = uomValue;
}

    // Getters and Setters
    public ItemUOMasterId getId() {
        return id;
    }

    public void setId(ItemUOMasterId id) {
        this.id = id;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getRcf() {
        return rcf;
    }

    public void setRcf(String rcf) {
        this.rcf = rcf;
    }
}
