/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.vehicleservice;

import edu.du.sirigaddepriyanka.model.domain.Vehicle;
import edu.du.sirigaddepriyanka.model.services.IServices;
import java.util.ArrayList;

/**
 *
 * @author priyankasirigadde
 */
public interface IVehicleService extends IServices {

    public final String NAME = "IVehicleService";

    public boolean add(Vehicle vehicle);

    public boolean remove(Vehicle vehicle);

    public boolean remove(String vehicleID);

    public boolean removeByOwner(String ownerID) throws Exception;

    public Vehicle find(String vehicleID);

    public boolean isUnique(String vehicleID);

    public boolean isUnique(Vehicle vehicle);

    public void dump();

    public ArrayList<Vehicle> getVehicleArrayList();
}
