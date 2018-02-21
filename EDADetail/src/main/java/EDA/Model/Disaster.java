/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA.Model;

import java.util.Date;

/**
 *

 */
public class Disaster {
    private long disasterNo;
    private String disasterName;
    private String catName;
    private String disasDesp;
    private Date createDate;
    private String location;

    public Disaster() {
    }

    public Disaster(long disasterNo, String disasterName, String catName, String disasDesp, Date createDate) {
        this.disasterNo = disasterNo;
        this.disasterName = disasterName;
        this.catName = catName;
        this.disasDesp = disasDesp;
        this.createDate = createDate;
    }

    public long getDisasterNo() {
        return disasterNo;
    }

    public void setDisasterNo(long disasterNo) {
        this.disasterNo = disasterNo;
    }

    public String getDisasterName() {
        return disasterName;
    }

    public void setDisasterName(String disasterName) {
        this.disasterName = disasterName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getDisasDesp() {
        return disasDesp;
    }

    public void setDisasDesp(String disasDesp) {
        this.disasDesp = disasDesp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
}
