/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.carshowownerservice;

import edu.du.sirigaddepriyanka.model.domain.CarShowOwner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowOwnerArrayListImpl implements ICarShowOwnerService {

    private static ArrayList<CarShowOwner> carShowOwnerArrayList = new ArrayList<>();

    /**
     *
     */
    public CarShowOwnerArrayListImpl() {
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<CarShowOwner> getCarShowOwnerArrayList() {
        return carShowOwnerArrayList;
    }

    /**
     *
     * @param carShowOwnerArrayList
     */
    public void setCarShowOwnerArrayList(ArrayList<CarShowOwner> carShowOwnerArrayList) {
        CarShowOwnerArrayListImpl.carShowOwnerArrayList = carShowOwnerArrayList;
    }

    /**
     *adds the element into the Array List
     * @param carShowOwner
     * @return
     */
    @Override
    public boolean add(CarShowOwner carShowOwner) {
        return carShowOwnerArrayList.add(carShowOwner);
    }

    /**
     *removes the element from the Array List
     * @param carShowOwner
     * @return
     */
    @Override
    public boolean remove(CarShowOwner carShowOwner) {
        return carShowOwnerArrayList.remove(carShowOwner);
    }

    /**
     *removes the element from the Array List of the owner ID
     * @param ownerID
     * @return
     * @throws Exception
     */
    @Override
    public boolean removeByOwner(String ownerID) throws Exception {
        boolean value = false;
        try {
            Iterator<CarShowOwner> itr = carShowOwnerArrayList.iterator();
            while (itr.hasNext()) {
                CarShowOwner carShowOwner = itr.next();
                if ((carShowOwner.getOwnerID()).equals(ownerID)) {
                    itr.remove();
                    value = true;
                }
            }
        } catch (Exception e) {
            throw new Exception("Exception occurred while removing car shows "
                    + "owned by owner with ID : " + ownerID + "due to " + e);
        }
        return value;
    }

    /**
     *removes the element from the Array List of the car show ID
     * @param carShowID
     * @return
     * @throws Exception
     */
    @Override
    public boolean removeByCarShow(String carShowID) throws Exception {
        boolean value = false;
        try {
            Iterator<CarShowOwner> itr = carShowOwnerArrayList.iterator();
            while (itr.hasNext()) {
                CarShowOwner carShowOwner = itr.next();
                if ((carShowOwner.getCarShowID()).equals(carShowID)) {
                    itr.remove();
                    value = true;
                }
            }
        } catch (Exception e) {
            throw new Exception("Exception occurred while removing car shows with ID : " + carShowID + "due to " + e);
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
        for (int i = 0; i < carShowOwnerArrayList.size(); i++) {
            if (carShowID.equals(carShowOwnerArrayList.get(i).getCarShowID())
                    & ownerID.equals(carShowOwnerArrayList.get(i).getOwnerID())) {
                value = false;
            }
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
        if (carShowOwnerArrayList.contains(carShowOwner)) {
            value = false;
        }
        return value;
    }

    /**
     *Prints all the elements of Array List
     */
    @Override
    public void dump() {
        Iterator<CarShowOwner> itr = carShowOwnerArrayList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
    }

}
