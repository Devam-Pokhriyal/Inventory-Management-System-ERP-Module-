package com.example.demo.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_category_master")
public class SubCategoryMaster {

    @EmbeddedId
    private SubCategoryMasterId id;

    private String description;

    // Getters and Setters
    public SubCategoryMasterId getId() {
        return id;
    }

    public void setId(SubCategoryMasterId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
