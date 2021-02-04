/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.carshowservice;

import edu.du.sirigaddepriyanka.model.domain.CarShow;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowArrayListImpl implements ICarShowService {

    private static ArrayList<CarShow> carShowArrayList = new ArrayList<>();

    /**
     *
     */
    public CarShowArrayListImpl() {
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<CarShow> getCarShowArrayList() {
        return carShowArrayList;
    }

    /**
     *
     * @param carShowArrayList
     */
    public void setCarShowArrayList(ArrayList<CarShow> carShowArrayList) {
        CarShowArrayListImpl.carShowArrayList = carShowArrayList;
    }

    /**
     *adds the element from the Array List
     * @param carShow
     * @return
     */
    @Override
    public boolean add(CarShow carShow) {
        return carShowArrayList.add(carShow);
    }

    /**
     *removes the element from the Array List
     * @param carShow
     * @return
     */
    @Override
    public boolean remove(CarShow carShow) {
        return carShowArrayList.remove(carShow);
    }

    /**
     *removes the element from the Array List
     * @param carShowID
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public boolean remove(String carShowID) throws Exception {
        boolean value = false;
        try {
            Iterator<CarShow> itr = carShowArrayList.iterator();
            while (itr.hasNext()) {
                CarShow carShow = itr.next();
                if ((carShow.getCarShowID()).equals(carShowID)) {
                    itr.remove();
                    value = true;
                }
            }
        } catch (Exception e) {
            throw new Exception("Exception occurred while removing owner", e);
        }
        return value;
    }

    /**
     *finds the element from the ArrayList
     * @param carShowID
     * @return
     */
    @Override
    public CarShow find(String carShowID) {
        CarShow carShow = null;
        for (int i = 0; i < carShowArrayList.size(); i++) {
            if (carShowID.equals(carShowArrayList.get(i).getCarShowID())) {
                carShow = carShowArrayList.get(i);
            }
        }
        return carShow;
    }

    /**
     *checks if the element is unique
     * @param carShowID
     * @return
     */
    @Override
    public boolean isUnique(String carShowID) {
        boolean value = true;
        for (int i = 0; i < carShowArrayList.size(); i++) {
            if (carShowID.equals(carShowArrayList.get(i).getCarShowID())) {
                value = false;
            }
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
        boolean value = true;
        if (carShowArrayList.contains(carShow)) {
            value = false;
        }
        return value;
    }

    /**
     *prints all the elements of the ArrayList
     */
    @Override
    public void dump() {
        Iterator<CarShow> itr = carShowArrayList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
    }
}
