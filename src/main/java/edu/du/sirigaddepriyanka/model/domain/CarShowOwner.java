/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.domain;

import java.util.Objects;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowOwner {

    private String carShowID;
    private String ownerID;

    /**
     *
     */
    public CarShowOwner() {
    }

    /**
     *
     * @param carShowID
     * @param ownerID
     */
    public CarShowOwner(String carShowID, String ownerID) {
        this.carShowID = carShowID;
        this.ownerID = ownerID;
    }

    /**
     *
     * @return
     */
    public String getOwnerID() {
        return ownerID;
    }

    /**
     *
     * @param ownerID
     */
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
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

    @Override
    public String toString() {
        return "CarShowOwner{" + "carShowID=" + carShowID + ", ownerID=" + ownerID + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final CarShowOwner other = (CarShowOwner) obj;
        if (!Objects.equals(this.carShowID, other.carShowID)) {
            return false;
        }
        if (!Objects.equals(this.ownerID, other.ownerID)) {
            return false;
        }
        return true;
    }

}
