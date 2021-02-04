/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.business.manager.vehiclemanager;

import edu.du.sirigaddepriyanka.model.business.manager.Manager;
import edu.du.sirigaddepriyanka.model.domain.Vehicle;
import edu.du.sirigaddepriyanka.model.services.vehicleservice.IVehicleService;
import java.util.ArrayList;

/**
 *
 * @author priyankasirigadde
 */
public class VehicleManager extends Manager {

    /**
     *adds the element 
     * @param vehicle
     * @return Boolean
     * @throws Exception
     */
    public boolean add(Vehicle vehicle) throws Exception {
        boolean value = false;
        try {
            IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
            value = vehicleService.add(vehicle);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *removes the element
     * @param vehicle
     * @return Boolean
     * @throws Exception
     */
    public boolean remove(Vehicle vehicle) throws Exception {
        boolean value = false;
        try {
            IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
            value = vehicleService.remove(vehicle);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *removes the element
     * @param vehicleID
     * @return Boolean
     * @throws Exception
     */
    public boolean remove(String vehicleID) throws Exception {
        boolean value = false;
        try {
            IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
            value = vehicleService.remove(vehicleID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *removes the element
     * @param ownerID
     * @return Boolean
     * @throws Exception
     */
    public boolean removeByOwner(String ownerID) throws Exception {
        boolean value = false;
        try {
            IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
            value = vehicleService.removeByOwner(ownerID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *finds the element 
     * @param vehicleID
     * @return Vehicle
     * @throws Exception
     */
    public Vehicle find(String vehicleID) throws Exception {
        Vehicle vehicle = new Vehicle();
        try {
            IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
            vehicle = vehicleService.find(vehicleID);
        } catch (Exception e) {
            throw e;
        }
        return vehicle;
    }

    /**
     *Checks if the element is unique
     * @param vehicleID
     * @return Boolean
     * @throws Exception
     */
    public boolean isUnique(String vehicleID) throws Exception {
        boolean value = false;
        try {
            IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
            value = vehicleService.isUnique(vehicleID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *Checks if the element is unique
     * @param vehicle
     * @return Boolean
     * @throws Exception
     */
    public boolean isUnique(Vehicle vehicle) throws Exception {
        boolean value = false;
        try {
            IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
            value = vehicleService.isUnique(vehicle);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *prints all the elements
     * @throws Exception
     */
    public void dump() throws Exception {
        try {
            IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
            vehicleService.dump();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *gets all the elements
     * @return ArrayList
     * @throws Exception
     */
    public ArrayList<Vehicle> getArrayList() throws Exception {
        ArrayList<Vehicle> value = new ArrayList<>();
        try {
            IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
            value = vehicleService.getVehicleArrayList();
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
