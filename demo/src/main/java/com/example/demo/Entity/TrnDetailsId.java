package com.example.demo.Entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrnDetailsId implements Serializable {
    private String trnRefNo;
    private Integer lineNumber;

    // Getters and Setters
    public String getTrnRefNo() {
        return trnRefNo;
    }

    public void setTrnRefNo(String trnRefNo) {
        this.trnRefNo = trnRefNo;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrnDetailsId that = (TrnDetailsId) o;
        return Objects.equals(trnRefNo, that.trnRefNo) &&
               Objects.equals(lineNumber, that.lineNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trnRefNo, lineNumber);
    }
}
