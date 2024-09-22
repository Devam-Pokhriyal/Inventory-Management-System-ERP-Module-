package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "trn_header")
public class TrnHeader {
    @Id
    private String trnRefNo;

    private Date trnDate;
    private String vendorCode;
    private String refNo;
    private String trnType;
    private String trnCode;
    private String createdBy;
    private String createdFor;
    private String status;
    public String getTrnRefNo() {
        return trnRefNo;
    }
    public void setTrnRefNo(String trnRefNo) {
        this.trnRefNo = trnRefNo;
    }
    public Date getTrnDate() {
        return trnDate;
    }
    public void setTrnDate(Date trnDate) {
        this.trnDate = trnDate;
    }
    public String getVendorCode() {
        return vendorCode;
    }
    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }
    public String getRefNo() {
        return refNo;
    }
    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }
    public String getTrnType() {
        return trnType;
    }
    public void setTrnType(String trnType) {
        this.trnType = trnType;
    }
    public String getTrnCode() {
        return trnCode;
    }
    public void setTrnCode(String trnCode) {
        this.trnCode = trnCode;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedFor() {
        return createdFor;
    }
    public void setCreatedFor(String createdFor) {
        this.createdFor = createdFor;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Getters and Setters
}
