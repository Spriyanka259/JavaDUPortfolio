/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.domain;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author priyankasirigadde
 */
public class CarShow {

    private String carShowID;
    private String carShowTitle;
    private Date carShowDate;
    private boolean isSanctioned;

    /**
     *
     */
    public CarShow() {
    }

    /**
     *
     * @param carShowID
     * @param carShowTitle
     * @param carShowDate
     * @param isSanctioned
     */
    public CarShow(String carShowID, String carShowTitle, Date carShowDate, boolean isSanctioned) {
        this.carShowID = carShowID;
        this.carShowTitle = carShowTitle;
        this.carShowDate = carShowDate;
        this.isSanctioned = isSanctioned;
    }

    /**
     *
     * @return
     */
    public boolean isIsSanctioned() {
        return isSanctioned;
    }

    /**
     *
     * @param isSanctioned
     */
    public void setIsSanctioned(boolean isSanctioned) {
        this.isSanctioned = isSanctioned;
    }

    public void setIsSanctioned(char value) {
        if (Character.toString(value).equals("Y")) {
            this.isSanctioned = true;
        } else {
            this.isSanctioned = false;
        }
    }

    public void setIsSanctioned(String isSanctioned) {
        if (isSanctioned.equals("YES")) {
            this.isSanctioned = true;
        } else {
            this.isSanctioned = false;
        }
    }

    public void setIsSanctioned(int isSanctioned) {
        if (isSanctioned == 0) {
            this.isSanctioned = false;
        } else {
            this.isSanctioned = true;
        }
    }

    /**
     *
     * @return
     */
    public String getCarShowID() {
        return carShowID;
    }

    /**
     *
     * @param carShowID
     */
    public void setCarShowID(String carShowID) {
        this.carShowID = carShowID;
    }

    /**
     *
     * @return
     */
    public String getCarShowTitle() {
        return carShowTitle;
    }

    /**
     *
     * @param carShowTitle
     */
    public void setCarShowTitle(String carShowTitle) {
        this.carShowTitle = carShowTitle;
    }

    /**
     *
     * @return
     */
    public Date getCarShowDate() {
        return carShowDate;
    }

    /**
     *
     * @param carShowDate
     */
    public void setCarShowDate(Date carShowDate) {
        this.carShowDate = carShowDate;
    }

    @Override
    public String toString() {
        return "CarShow{" + "carShowID=" + carShowID + ", carShowTitle=" + carShowTitle + ", carShowDate=" + carShowDate + ", isSanctioned=" + isSanctioned + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarShow other = (CarShow) obj;
        if (this.isSanctioned != other.isSanctioned) {
            return false;
        }
        if (!Objects.equals(this.carShowID, other.carShowID)) {
            return false;
        }
        if (!Objects.equals(this.carShowTitle, other.carShowTitle)) {
            return false;
        }
        if (!Objects.equals(this.carShowDate, other.carShowDate)) {
            return false;
        }
        return true;
    }

}
