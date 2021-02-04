/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.business.manager.carshowownermanager;

import edu.du.sirigaddepriyanka.model.business.manager.Manager;
import edu.du.sirigaddepriyanka.model.domain.CarShowOwner;
import edu.du.sirigaddepriyanka.model.services.carshowownerservice.ICarShowOwnerService;
import java.util.ArrayList;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowOwnerManager extends Manager {

    /**
     *adds the element 
     * @param carShowOwner
     * @return Boolean
     * @throws Exception
     */
    public boolean add(CarShowOwner carShowOwner) throws Exception {
        boolean value = false;
        try {
            ICarShowOwnerService carShowOwnerService = (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
            value = carShowOwnerService.add(carShowOwner);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *removes the element
     * @param carShowOwner
     * @return Boolean
     * @throws Exception
     */
    public boolean remove(CarShowOwner carShowOwner) throws Exception {
        boolean value = false;
        try {
            ICarShowOwnerService carShowOwnerService = (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
            value = carShowOwnerService.remove(carShowOwner);
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
            ICarShowOwnerService carShowOwnerService = (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
            value = carShowOwnerService.removeByOwner(ownerID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *removes the element
     * @param carShowID
     * @return Boolean
     * @throws Exception
     */
    public boolean removeByCarShow(String carShowID) throws Exception {
        boolean value = false;
        try {
            ICarShowOwnerService carShowOwnerService = (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
            value = carShowOwnerService.removeByCarShow(carShowID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *checks if the element is unique
     * @param ownerID
     * @param carShowID
     * @return Boolean
     * @throws Exception
     */
    public boolean isUnique(String ownerID, String carShowID) throws Exception {
        boolean value = false;
        try {
            ICarShowOwnerService carShowOwnerService = (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
            value = carShowOwnerService.isUnique(ownerID, carShowID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *checks if the element is unique
     * @param carShowOwner
     * @return Boolean
     * @throws Exception
     */
    public boolean isUnique(CarShowOwner carShowOwner) throws Exception {
        boolean value = false;
        try {
            ICarShowOwnerService carShowOwnerService = (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
            value = carShowOwnerService.isUnique(carShowOwner);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *Prints all the elements of the Array List
     * @throws Exception
     */
    public void dump() throws Exception {
        try {
            ICarShowOwnerService carShowOwnerService = (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
            carShowOwnerService.dump();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *gets all the elements of the Array List
     * @return ArrayList
     * @throws Exception
     */
    public ArrayList<CarShowOwner> getArrayList() throws Exception {
        ArrayList<CarShowOwner> value = new ArrayList<>();
        try {
            ICarShowOwnerService carShowOwnerService = (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
            value = carShowOwnerService.getCarShowOwnerArrayList();
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
