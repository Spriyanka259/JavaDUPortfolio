/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.vehicleservice;

import edu.du.sirigaddepriyanka.model.domain.Vehicle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author priyankasirigadde
 */
public class VehicleHashMapImpl implements IVehicleService {

    private static Map<String, Vehicle> vehicleHashMap = new HashMap<>();

    /**
     *
     * @return 
     */
    public static Map<String, Vehicle> getVehicleHashMap() {
        return vehicleHashMap;
    }

    /**
     *
     * @param aVehicleHashMap
     */
    public static void setVehicleHashMap(Map<String, Vehicle> aVehicleHashMap) {
        vehicleHashMap = aVehicleHashMap;
    }

    /**
     *
     */
    public VehicleHashMapImpl() {
    }

    /**
     *adds the element to the Array List
     * @param vehicle
     * @return 
     */
    @Override
    public boolean add(Vehicle vehicle) {
        boolean value = false;
        Vehicle addedVehicle = vehicleHashMap.put(vehicle.getVehicleID(), vehicle);
        if (addedVehicle == null) {
            value = true;
        }
        return value;
    }

    /**
     *removes the element from the Array List
     * @param vehicle
     * @return 
     */
    @Override
    public boolean remove(Vehicle vehicle) {
        boolean value = false;
        Iterator<Vehicle> itr = vehicleHashMap.values().iterator();
        while (itr.hasNext()) {
            if ((vehicle.getVehicleID()).equals(itr.next().getVehicleID())) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *removes the element from the Array List
     * @param vehicleID
     * @return
     */
    @Override
    public boolean remove(String vehicleID) {
        boolean value = false;
        Iterator<String> itr = vehicleHashMap.keySet().iterator();
        while (itr.hasNext()) {
            String id = itr.next();
            if (id.equals(vehicleID)) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *removes the element from the Array List
     * @param ownerID
     * @return 
     * @throws java.lang.Exception
     */
    @Override
    public boolean removeByOwner(String ownerID) throws Exception {
        boolean value = false;
        Iterator<Vehicle> itr = vehicleHashMap.values().iterator();
        while (itr.hasNext()) {
            if ((itr.next().getOwnerID()).equals(ownerID)) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *finds the element from the Array List
     * @param vehicleID
     * @return 
     */
    @Override
    public Vehicle find(String vehicleID) {
        return vehicleHashMap.get(vehicleID);
    }

    /**
     *checks if the element is unique
     * @param vehicleID
     * @return 
     */
    @Override
    public boolean isUnique(String vehicleID) {
        boolean value = false;
        Vehicle foundVehicle = vehicleHashMap.get(vehicleID);
        if (foundVehicle == null) {
            value = true;
        }
        return value;
    }

    /**
     *checks if the element is unique
     * @param vehicle
     * @return 
     */
    @Override
    public boolean isUnique(Vehicle vehicle) {
        boolean value = false;
        Vehicle foundVehicle = vehicleHashMap.get(vehicle.getVehicleID());
        if (foundVehicle == null) {
            value = true;
        }
        return value;
    }

    /**
     *prints all the elements of the Array List
     */
    @Override
    public void dump() {
        if (!vehicleHashMap.isEmpty()) {
            Iterator<Vehicle> itr = vehicleHashMap.values().iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next().toString());
            }
        }
    }

    /**
     *converts all the elements of the HashMap into Array List
     * @return 
     */
    @Override
    public ArrayList<Vehicle> getVehicleArrayList() {
        Collection<Vehicle> values = vehicleHashMap.values();
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<>(values);
        return vehicleArrayList;
    }

}
