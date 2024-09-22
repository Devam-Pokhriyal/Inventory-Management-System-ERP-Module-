package com.example.demo.Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "trn_def")
public class TrnDef implements Serializable {

    @Embeddable
    public static class TrnDefId implements Serializable {
        private String trnType;
        private String trnCode;

        // Constructors, getters, setters, equals, and hashCode

        public TrnDefId() {}

        public TrnDefId(String trnType, String trnCode) {
            this.trnType = trnType;
            this.trnCode = trnCode;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TrnDefId trnDefId = (TrnDefId) o;
            return Objects.equals(trnType, trnDefId.trnType) &&
                   Objects.equals(trnCode, trnDefId.trnCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(trnType, trnCode);
        }
    }

    @EmbeddedId
    private TrnDefId id;

    

    @Column(name = "trn_description")
    private String trnDescription;

    @Column(name = "series")
    private String series;

    @Column(name = "nextno")
    private Long nextno;

    @Column(name = "serial")
    private Integer serial;

    // Getters and Setters

    public TrnDefId getId() {
        return id;
    }

    public void setId(TrnDefId id) {
        this.id = id;
    }

    public String getTrnDescription() {
        return trnDescription;
    }

    public void setTrnDescription(String trnDescription) {
        this.trnDescription = trnDescription;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Long getNextno() {
        return nextno;
    }

    public void setNextno(Long nextno) {
        this.nextno = nextno;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }
}
