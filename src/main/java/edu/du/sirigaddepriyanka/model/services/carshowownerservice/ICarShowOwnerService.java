/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.carshowownerservice;

import edu.du.sirigaddepriyanka.model.domain.CarShowOwner;
import edu.du.sirigaddepriyanka.model.services.IServices;
import java.util.ArrayList;

/**
 *
 * @author priyankasirigadde
 */
public interface ICarShowOwnerService extends IServices {

    public final String NAME = "ICarShowOwnerService";

    public boolean add(CarShowOwner carShowOwner);

    public boolean remove(CarShowOwner carShowOwner);

    public boolean removeByOwner(String ownerID) throws Exception;

    public boolean removeByCarShow(String carShowID) throws Exception;

    public boolean isUnique(String ownerID, String carShowID);

    public boolean isUnique(CarShowOwner carShowOwner);

    public void dump();

    public ArrayList<CarShowOwner> getCarShowOwnerArrayList() throws Exception;

}
