/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.carshowownerservice;

import edu.du.sirigaddepriyanka.model.domain.CarShowOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowOwnerHashMapImpl implements ICarShowOwnerService {

    private static Map<String, CarShowOwner> carShowOwnerHashMap = new HashMap<>();

    public static Map<String, CarShowOwner> getCarShowOwnerHashMap() {
        return carShowOwnerHashMap;
    }

    /**
     *
     * @param carShowOwnerHashMap
     */
    public static void setCarShowOwnerHashMap(Map<String, CarShowOwner> carShowOwnerHashMap) {
        CarShowOwnerHashMapImpl.carShowOwnerHashMap = carShowOwnerHashMap;
    }

    /**
     *
     */
    public CarShowOwnerHashMapImpl() {
    }

    /**
     *adds the element into the HashMap
     * @param carShowOwner
     * @return
     */
    @Override
    public boolean add(CarShowOwner carShowOwner) {
        boolean value = false;
        String key = carShowOwner.getCarShowID() + carShowOwner.getOwnerID();
        CarShowOwner removedCarShowOwner = carShowOwnerHashMap.put(key, carShowOwner);
        if (removedCarShowOwner == null) {
            value = true;
        }
        return value;
    }

    /**
     *removes the element from the HashMap
     * @param carShowOwner
     * @return
     */
    @Override
    public boolean remove(CarShowOwner carShowOwner) {
        boolean value = false;
        Iterator<CarShowOwner> itr = carShowOwnerHashMap.values().iterator();
        while (itr.hasNext()) {
            if ((carShowOwner.getCarShowID()).equals(itr.next().getCarShowID())) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *removes the element from the HashMap of the owner ID
     * @param ownerID
     * @return
     * @throws Exception
     */
    @Override
    public boolean removeByOwner(String ownerID) throws Exception {
        boolean value = false;
        Iterator<CarShowOwner> itr = carShowOwnerHashMap.values().iterator();
        while (itr.hasNext()) {
            if ((itr.next().getOwnerID()).equals(ownerID)) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *removes the element from the HashMap of the car show ID
     * @param carShowID
     * @return
     * @throws Exception
     */
    @Override
    public boolean removeByCarShow(String carShowID) throws Exception {
        boolean value = false;
        Iterator<CarShowOwner> itr = carShowOwnerHashMap.values().iterator();
        while (itr.hasNext()) {
            if ((itr.next().getCarShowID()).equals(carShowID)) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *checks if the element is unique
     * @param ownerID
     * @param carShowID
     * @return
     */
    @Override
    public boolean isUnique(String ownerID, String carShowID) {
        boolean value = true;
        String key = carShowID + ownerID;
        CarShowOwner foundCarShowOwner = carShowOwnerHashMap.get(key);
        if (foundCarShowOwner == null) {
            value = true;
        }
        return value;
    }

    /**
     *checks if the element is unique
     * @param carShowOwner
     * @return
     */
    @Override
    public boolean isUnique(CarShowOwner carShowOwner) {
        boolean value = true;
        if (carShowOwnerHashMap.containsValue(carShowOwner)) {
            value = false;
        }
        return value;
    }

    /**
     *Prints all the elements of HashMap
     */
    @Override
    public void dump() {
        if (!carShowOwnerHashMap.isEmpty()) {
            Iterator<CarShowOwner> itr = carShowOwnerHashMap.values().iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next().toString());
            }
        }
    }

    /**
     *Converts all the elements of HashMap into the ArrayList
     * @return 
     * @throws java.lang.Exception 
     */
    @Override
    public ArrayList<CarShowOwner> getCarShowOwnerArrayList() throws Exception {
        Collection<CarShowOwner> values = carShowOwnerHashMap.values();
        ArrayList<CarShowOwner> carShowOwnerArrayList = new ArrayList<>(values);
        return carShowOwnerArrayList;
    }

}
