/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.persistservice;

import edu.du.sirigaddepriyanka.model.business.manager.carshowmanager.CarShowManager;
import edu.du.sirigaddepriyanka.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.sirigaddepriyanka.model.business.manager.ownermanager.OwnerManager;
import edu.du.sirigaddepriyanka.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.sirigaddepriyanka.model.services.IServices;

/**
 *
 * @author priyankasirigadde
 */
public interface IPersistService extends IServices {

    public final String NAME = "IPersistService";

    public void loadPersistData(OwnerManager ownerManager, VehicleManager vehicleManager, CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager);

    public void putPersistData(OwnerManager ownerManager, VehicleManager vehilceManager, CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager);
}
