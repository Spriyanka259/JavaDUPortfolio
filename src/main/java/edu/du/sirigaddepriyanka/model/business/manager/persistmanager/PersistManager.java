/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.business.manager.persistmanager;

import edu.du.sirigaddepriyanka.model.business.manager.Manager;
import edu.du.sirigaddepriyanka.model.business.manager.carshowmanager.CarShowManager;
import edu.du.sirigaddepriyanka.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.sirigaddepriyanka.model.business.manager.ownermanager.OwnerManager;
import edu.du.sirigaddepriyanka.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.sirigaddepriyanka.model.services.persistservice.IPersistService;

/**
 *
 * @author priyankasirigadde
 */
public class PersistManager extends Manager {

    /**
     *loads the data
     * @param ownerManager
     * @param vehicleManager
     * @param carShowManager
     * @param carShowOwnerManager
     * @throws Exception
     */
    public void loadPersistData(OwnerManager ownerManager, VehicleManager vehicleManager, CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception {
        try {
            IPersistService persistService = (IPersistService) getPersistService(IPersistService.NAME);
            persistService.loadPersistData(ownerManager, vehicleManager, carShowManager, carShowOwnerManager);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *puts the data
     * @param ownerManager
     * @param vehicleManager
     * @param carShowManager
     * @param carShowOwnerManager
     * @throws Exception
     */
    public void putPersistData(OwnerManager ownerManager, VehicleManager vehicleManager, CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception {
        try {
            IPersistService persistService = (IPersistService) getPersistService(IPersistService.NAME);
            persistService.putPersistData(ownerManager, vehicleManager, carShowManager, carShowOwnerManager);
        } catch (Exception e) {
            throw e;
        }
    }
}
