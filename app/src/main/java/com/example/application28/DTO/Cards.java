package com.example.application28.DTO;

import java.util.Date;

public class Cards {
    private Integer Cid;
    private String cName;
    private String cType;
    private java.sql.Date cStartingDate;

    private java.sql.Date cExpireDate;

    public Cards(String cName, String cType, java.sql.Date cStartingDate, java.sql.Date cExpireDate) {
        this.cName = cName;
        this.cType = cType;
        this.cStartingDate = cStartingDate;
        this.cExpireDate = cExpireDate;
    }


    public Integer getCid() {
        return Cid;
    }

    public void setCid(Integer cid) {
        Cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public java.sql.Date getcStartingDate() {
        return cStartingDate;
    }

    public void setcStartingDate(java.sql.Date cStartingDate) {
        this.cStartingDate = cStartingDate;
    }

    public java.sql.Date getcExpireDate() {
        return cExpireDate;
    }

    public void setcExpireDate(java.sql.Date cExpireDate) {
        this.cExpireDate = cExpireDate;
    }



        public Date getFormattedStartDate() {
            return new Date(cStartingDate.getTime());
        }

        public Date getFormattedExpireDate() {
            return new Date(cExpireDate.getTime());
        }

}
