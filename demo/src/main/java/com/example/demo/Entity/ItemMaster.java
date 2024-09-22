package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ItemMaster {

    @Id
    @Column(name = "item_code") // Specify the column name in the database
    private String itemCode;

    @Column(name = "category_name") // Specify the column name in the database
    private String categoryName;



    @Column(name = "subcategory") // Specify the column name in the database
    private String subCategory;

    @Column(name = "unit_of_measure") // Specify the column name in the database
    private String unitOfMeasure;

    @Column(name = "unit_price") // Specify the column name in the database
    private Double unitPrice;

    @Column(name = "cost_price") // Specify the column name in the database
    private Double costPrice;

    @Column(name = "hsn_code") // Specify the column name in the database
    private String hsnCode; 
    @Column(name = "item_description") // Specify the column name in the database
    private String itemDescription; 


    @Column(name = "number_of_items")
    private String numberOfItems;
    // Getters and Setters
    public String getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(String numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

   
    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }
}
