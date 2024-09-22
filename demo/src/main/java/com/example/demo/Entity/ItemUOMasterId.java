package com.example.demo.Entity;



import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemUOMasterId implements Serializable {
    private String fromUom;
    private String itemCode;
    private String toUom;

    // Getters and Setters
    public String getFromUom() {
        return fromUom;
    }

    public void setFromUom(String fromUom) {
        this.fromUom = fromUom;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getToUom() {
        return toUom;
    }

    public void setToUom(String toUom) {
        this.toUom = toUom;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemUOMasterId that = (ItemUOMasterId) o;
        return Objects.equals(fromUom, that.fromUom) &&
               Objects.equals(itemCode, that.itemCode) &&
               Objects.equals(toUom, that.toUom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromUom, itemCode, toUom);
    }
}

