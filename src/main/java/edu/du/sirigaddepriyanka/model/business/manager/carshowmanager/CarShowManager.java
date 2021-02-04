/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.business.manager.carshowmanager;

import edu.du.sirigaddepriyanka.model.business.manager.Manager;
import edu.du.sirigaddepriyanka.model.domain.CarShow;
import edu.du.sirigaddepriyanka.model.services.carshowservice.ICarShowService;
import java.util.ArrayList;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowManager extends Manager {

    /**
     *adds the element 
     * @param carShow
     * @return Boolean
     * @throws Exception
     */
    public boolean add(CarShow carShow) throws Exception {
        boolean value = false;
        try {
            ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
            value = carShowService.add(carShow);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *removes the element
     * @param carShow
     * @return Boolean
     * @throws Exception
     */
    public boolean remove(CarShow carShow) throws Exception {
        boolean value = false;
        try {
            ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
            value = carShowService.remove(carShow);
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
    public boolean remove(String carShowID) throws Exception {
        boolean value = false;
        try {
            ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
            value = carShowService.remove(carShowID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *finds the element
     * @param carShowID
     * @return CarShow
     * @throws Exception
     */
    public CarShow find(String carShowID) throws Exception {
        CarShow carShow = new CarShow();
        try {
            ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
            carShow = carShowService.find(carShowID);
        } catch (Exception e) {
            throw e;
        }
        return carShow;
    }

    /**
     *checks if the element is unique
     * @param carShowID
     * @return Boolean
     * @throws Exception
     */
    public boolean isUnique(String carShowID) throws Exception {
        boolean value = false;
        try {
            ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
            value = carShowService.isUnique(carShowID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *checks if the element is unique
     * @param carShow
     * @return Boolean
     * @throws Exception
     */
    public boolean isUnique(CarShow carShow) throws Exception {
        boolean value = false;
        try {
            ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
            value = carShowService.isUnique(carShow);
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
            ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
            carShowService.dump();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *gets all the elements of the Array List
     * @return ArrayList
     * @throws Exception
     */
    public ArrayList<CarShow> getArrayList() throws Exception {
        ArrayList<CarShow> value = new ArrayList<>();
        try {
            ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
            value = carShowService.getCarShowArrayList();
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
