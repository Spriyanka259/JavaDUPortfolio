/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.domain;

/**
 *
 * @author priyankasirigadde
 */
public enum VehicleClassification {
    ANTIQUE,
    CLASSIC,
    MODERN;

    VehicleClassification() {
    }

    public String getStatus() {
        return this.name();
    }
}
