/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.carshowservice;

import edu.du.sirigaddepriyanka.model.domain.CarShow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowHashMapImpl implements ICarShowService {

    private static Map<String, CarShow> carShowHashMap = new HashMap<>();

    /**
     *
     */
    public CarShowHashMapImpl() {
    }

    /**
     *
     * @return 
     */
    public static Map<String, CarShow> getCarShowHashMap() {
        return carShowHashMap;
    }

    /**
     *
     * @param carShowHashMap
     */
    public static void setCarShowHashMap(Map<String, CarShow> carShowHashMap) {
        CarShowHashMapImpl.carShowHashMap = carShowHashMap;
    }

    /**
     *adds the element into the HashMap
     * @param carShow
     * @return
     */
    @Override
    public boolean add(CarShow carShow) {
        boolean value = false;
        CarShow addedCarShow = carShowHashMap.put(carShow.getCarShowID(), carShow);
        if (addedCarShow == null) {
            value = true;
        }
        return value;
    }

    /**
     *removes the element from the HashMap
     * @param carShow
     * @return
     */
    @Override
    public boolean remove(CarShow carShow) {
        boolean value = false;
        Iterator<CarShow> itr = carShowHashMap.values().iterator();
        while (itr.hasNext()) {
            if ((carShow.getCarShowID()).equals(itr.next().getCarShowID())) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *removes the element into the HashMap
     * @param carShowID
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public boolean remove(String carShowID) throws Exception {
        boolean value = false;
        Iterator<String> itr = carShowHashMap.keySet().iterator();
        while (itr.hasNext()) {
            String id = itr.next();
            if (id.equals(carShowID)) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *finds the element from the HashMap
     * @param carShowID
     * @return
     */
    @Override
    public CarShow find(String carShowID) {
        return carShowHashMap.get(carShowID);
    }

    /**
     *checks if the element is unique
     * @param carShowID
     * @return
     */
    @Override
    public boolean isUnique(String carShowID) {
        boolean value = false;
        CarShow foundCarShow = carShowHashMap.get(carShowID);
        if (foundCarShow == null) {
            value = true;
        }
        return value;
    }

    /**
     *checks if the element is unique
     * @param carShow
     * @return
     */
    @Override
    public boolean isUnique(CarShow carShow) {
        boolean value = false;
        CarShow foundCarShow = carShowHashMap.get(carShow.getCarShowID());
        if (foundCarShow == null) {
            value = true;
        }
        return value;
    }

    /**
     *Prints all the elements of HashMap
     */
    @Override
    public void dump() {
        if (!carShowHashMap.isEmpty()) {
            Iterator<CarShow> itr = carShowHashMap.values().iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next().toString());
            }
        }
    }

    /**
     *Converts all the elements of HashMap into the ArrayList
     * @return 
     */
    @Override
    public ArrayList<CarShow> getCarShowArrayList() {
        Collection<CarShow> values = carShowHashMap.values();
        ArrayList<CarShow> ownerArrayList = new ArrayList<>(values);
        return ownerArrayList;
    }

}
