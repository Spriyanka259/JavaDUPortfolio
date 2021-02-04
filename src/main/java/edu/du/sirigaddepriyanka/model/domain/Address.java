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
public class Address {

    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipcode;

    /**
     *
     */
    public Address() {
    }

    /**
     *
     * @param street1
     * @param street2
     * @param city
     * @param state
     * @param zipcode
     */
    public Address(String street1, String street2, String city, String state, String zipcode) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    /**
     *
     * @return
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     *
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     *
     * @return
     */
    public String getStreet1() {
        return street1;
    }

    /**
     *
     * @param street1
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     *
     * @return
     */
    public String getStreet2() {
        return street2;
    }

    /**
     *
     * @param street2
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" + "street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + '}';
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
        final Address other = (Address) obj;
        if (!Objects.equals(this.street1, other.street1)) {
            return false;
        }
        if (!Objects.equals(this.street2, other.street2)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zipcode, other.zipcode)) {
            return false;
        }
        return true;
    }

    public boolean validateState() {
        boolean value = false;
        if (this.state.length() == 2) {
            value = true;
        }
        return value;
    }

    public boolean validateZipcode() {
        boolean value = false;
        if (this.zipcode.length() == 10) {
            value = true;
        }
        return value;
    }

}
