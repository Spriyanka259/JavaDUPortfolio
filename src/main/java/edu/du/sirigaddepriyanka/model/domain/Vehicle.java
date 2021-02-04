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
public class Vehicle {

    private String vehicleID;
    private String ownerID;
    private String manufacturer;
    private int modelYear;
    private String model;
    private String subModel;
    private VehicleClassification vehicleClassification;
    private boolean isInsured;

    /**
     *
     */
    public Vehicle() {
    }

    /**
     *
     * @param vehicleID
     * @param ownerID
     * @param manufacturer
     * @param modelYear
     * @param model
     * @param subModel
     * @param vehicleClassification
     * @param isInsured
     */
    public Vehicle(String vehicleID, String ownerID, String manufacturer, int modelYear, String model, String subModel, VehicleClassification vehicleClassification, boolean isInsured) {
        this.vehicleID = vehicleID;
        this.ownerID = ownerID;
        this.manufacturer = manufacturer;
        this.modelYear = modelYear;
        this.model = model;
        this.subModel = subModel;
        this.vehicleClassification = vehicleClassification;
        this.isInsured = isInsured;
    }

    /**
     *
     * @return
     */
    public boolean isIsInsured() {
        return isInsured;
    }

    /**
     *
     * @param isInsured
     */
    public void setIsInsured(boolean isInsured) {
        this.isInsured = isInsured;
    }

    public void setIsInsured(String isInsured) {
        if (isInsured.equalsIgnoreCase("true")) {
            this.isInsured = true;
        } else if (isInsured.equalsIgnoreCase("false")) {
            this.isInsured = false;
        }
    }

    /**
     *
     * @return
     */
    public String getVehicleID() {
        return vehicleID;
    }

    /**
     *
     * @param vehicleID
     */
    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
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
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     *
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     *
     * @return
     */
    public int getModelYear() {
        return modelYear;
    }

    /**
     *
     * @param modelYear
     */
    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    /**
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @return
     */
    public String getSubModel() {
        return subModel;
    }

    /**
     *
     * @param subModel
     */
    public void setSubModel(String subModel) {
        this.subModel = subModel;
    }

    /**
     *
     * @return
     */
    public VehicleClassification getVehicleClassification() {
        return vehicleClassification;
    }

    /**
     *
     * @param vehicleClassification
     */
    public void setVehicleClassification(VehicleClassification vehicleClassification) {
        this.vehicleClassification = vehicleClassification;
    }

    public void setVehicleClassification(char value) {
        if (Character.toString(value).equals("A")) {
            this.vehicleClassification = VehicleClassification.ANTIQUE;
        } else if (Character.toString(value).equals("C")) {
            this.vehicleClassification = VehicleClassification.CLASSIC;
        } else if (Character.toString(value).equals("M")) {
            this.vehicleClassification = VehicleClassification.MODERN;
        }
    }

    public void setVehicleClassification() {
        if (modelYear < 1951) {
            this.vehicleClassification = VehicleClassification.ANTIQUE;
        } else if ((modelYear > 1950) && (modelYear < 1981)) {
            this.vehicleClassification = VehicleClassification.CLASSIC;
        } else if (modelYear > 1980) {
            this.vehicleClassification = VehicleClassification.MODERN;
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" + "vehicleID=" + vehicleID + ", ownerID=" + ownerID + ", manufacturer=" + manufacturer + ", modelYear=" + modelYear + ", model=" + model + ", subModel=" + subModel + ", vehicleClassification=" + vehicleClassification + ", isInsured=" + isInsured + '}';
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
        final Vehicle other = (Vehicle) obj;
        if (this.modelYear != other.modelYear) {
            return false;
        }
        if (this.isInsured != other.isInsured) {
            return false;
        }
        if (!Objects.equals(this.vehicleID, other.vehicleID)) {
            return false;
        }
        if (!Objects.equals(this.ownerID, other.ownerID)) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.subModel, other.subModel)) {
            return false;
        }
        if (this.vehicleClassification != other.vehicleClassification) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return @throws java.lang.Exception
     */
    public boolean validateVehicleClassification() throws Exception {
        boolean value = true;

        switch (this.vehicleClassification) {
            case ANTIQUE:
                if (this.modelYear > 1950) {
                    throw new IllegalArgumentException("Invalid year passed for ANTIQUE" + this.modelYear);
                }
                break;
            case CLASSIC:
                if ((this.modelYear < 1951) && (this.modelYear > 1980)) {
                    throw new IllegalArgumentException("Invalid year passed for CLASSIC" + this.modelYear);
                }
                break;
            case MODERN:
                if (this.modelYear < 1981) {
                    throw new IllegalArgumentException("Invalid year passed for MODERN" + this.modelYear);
                }
                break;
            default:
                break;
        }

        return value;
    }

}
