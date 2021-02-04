/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.carshowservice;

import edu.du.sirigaddepriyanka.model.domain.CarShow;
import edu.du.sirigaddepriyanka.model.services.IServices;
import java.util.ArrayList;

/**
 *
 * @author priyankasirigadde
 */
public interface ICarShowService extends IServices {

    public final String NAME = "ICarShowService";

    public boolean add(CarShow carShow);

    public boolean remove(CarShow carShow);

    public boolean remove(String carShowID) throws Exception;

    public CarShow find(String carShowID);

    public boolean isUnique(String carShowID);

    public boolean isUnique(CarShow carShow);

    public void dump();

    public ArrayList<CarShow> getCarShowArrayList();
}
