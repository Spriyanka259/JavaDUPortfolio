/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.vehicleservice;

import edu.du.sirigaddepriyanka.model.domain.Vehicle;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author priyankasirigadde
 */
public class VehicleArrayListImpl implements IVehicleService {

    private static ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();

    /**
     *
     */
    public VehicleArrayListImpl() {
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Vehicle> getVehicleArrayList() {
        return vehicleArrayList;
    }

    /**
     *
     * @param vehicleArrayList
     */
    public void setVehicleArrayList(ArrayList<Vehicle> vehicleArrayList) {
        this.vehicleArrayList = vehicleArrayList;
    }

    /**
     *adds the element from the Array List
     * @param vehicle
     * @return
     */
    @Override
    public boolean add(Vehicle vehicle) {
        return vehicleArrayList.add(vehicle);
    }

    /**
     *removes the element from the Array List
     * @param vehicle
     * @return
     */
    @Override
    public boolean remove(Vehicle vehicle) {
        return vehicleArrayList.remove(vehicle);
    }

    /**
     *removes the element from the Array List
     * @param vehicleID
     * @return
     */
    @Override
    public boolean remove(String vehicleID) {
        boolean value = false;
        Iterator<Vehicle> itr = vehicleArrayList.iterator();
        while (itr.hasNext()) {
            Vehicle vehicle = itr.next();
            if ((vehicle.getVehicleID()).equals(vehicleID)) {
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
        try {
            Iterator<Vehicle> itr = vehicleArrayList.iterator();
            while (itr.hasNext()) {
                Vehicle vehicle = itr.next();
                if ((vehicle.getOwnerID()).equals(ownerID)) {
                    itr.remove();
                    value = true;
                }
            }
        } catch (Exception e) {
            throw new Exception("Exception occurred while removing vehicles "
                    + "owned by owner with ID : " + ownerID + "due to " + e);
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
        Vehicle vehicle = null;
        for (int i = 0; i < vehicleArrayList.size(); i++) {
            if (vehicleID.equals(vehicleArrayList.get(i).getVehicleID())) {
                vehicle = vehicleArrayList.get(i);
            }
        }
        return vehicle;
    }

    /**
     *Checks if the element is unique
     * @param vehicleID
     * @return
     */
    @Override
    public boolean isUnique(String vehicleID) {
        boolean value = true;
        for (int i = 0; i < vehicleArrayList.size(); i++) {
            if (vehicleID.equals(vehicleArrayList.get(i).getVehicleID())) {
                value = false;
            }
        }
        return value;
    }

    /**
     *Checks if the element is unique
     * @param vehicle
     * @return
     */
    @Override
    public boolean isUnique(Vehicle vehicle) {
        boolean value = true;
        if (vehicleArrayList.contains(vehicle)) {
            value = false;
        }
        return value;
    }

    /**
     *prints all the elements from the Array List
     */
    @Override
    public void dump() {
        Iterator<Vehicle> itr = vehicleArrayList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
    }

}
