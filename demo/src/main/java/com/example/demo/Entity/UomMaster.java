package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "uom_master")
public class UomMaster {

    @Id
    private String name;
    private String description;
    private String uomCode;
    private String uomDesc;

    // Default constructor
    public UomMaster() {
    }

    // Parameterized constructor
    public UomMaster(String name, String description, String uomCode, String uomDesc) {
        this.name = name;
        this.description = description;
        this.uomCode = uomCode;
        this.uomDesc = uomDesc;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public String getUomDesc() {
        return uomDesc;
    }

    public void setUomDesc(String uomDesc) {
        this.uomDesc = uomDesc;
    }
}
