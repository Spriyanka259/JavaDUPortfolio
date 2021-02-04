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
public class Owner {

    private String ownerID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int numYears;
    private Address address;

    /**
     *
     */
    public Owner() {
    }

    /**
     *
     * @param ownerID
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param numYears
     * @param address
     */
    public Owner(String ownerID, String firstName, String lastName, String phoneNumber, int numYears, Address address) {
        this.ownerID = ownerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.numYears = numYears;
        this.address = address;
    }

    /**
     *
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
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
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     */
    public int getNumYears() {
        return numYears;
    }

    /**
     *
     * @param numYears
     */
    public void setNumYears(int numYears) {
        this.numYears = numYears;
    }

    @Override
    public String toString() {
        return "Owner{" + "ownerID=" + ownerID + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", numYears=" + numYears + ", address=" + address + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Owner other = (Owner) obj;
        if (this.numYears != other.numYears) {
            return false;
        }
        if (!Objects.equals(this.ownerID, other.ownerID)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public boolean isSeniorOwner() {
        boolean value = false;
        if (this.numYears > 20) {
            return true;
        }
        return value;
    }

}
