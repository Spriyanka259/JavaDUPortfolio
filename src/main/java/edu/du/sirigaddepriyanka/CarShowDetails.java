/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka;

import edu.du.sirigaddepriyanka.model.business.manager.carshowmanager.CarShowManager;
import edu.du.sirigaddepriyanka.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.sirigaddepriyanka.model.business.manager.ownermanager.OwnerManager;
import edu.du.sirigaddepriyanka.model.business.manager.persistmanager.PersistManager;
import edu.du.sirigaddepriyanka.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.sirigaddepriyanka.model.domain.Address;
import edu.du.sirigaddepriyanka.model.domain.CarShow;
import edu.du.sirigaddepriyanka.model.domain.CarShowOwner;
import edu.du.sirigaddepriyanka.model.domain.Owner;
import edu.du.sirigaddepriyanka.model.domain.Vehicle;
import edu.du.sirigaddepriyanka.view.CarShowMainMenu;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowDetails {

    static Address address;
    static Owner owner;
    static Vehicle vehicle;
    static CarShow carShow;
    static CarShowOwner carShowOwner;

    static OwnerManager ownerManager = new OwnerManager();
    static VehicleManager vehicleManager = new VehicleManager();
    static CarShowManager carShowManager = new CarShowManager();
    static CarShowOwnerManager carShowOwnerManager = new CarShowOwnerManager();
    static PersistManager persistManager = new PersistManager();
    private static final Logger LOGGER = Logger.getLogger(CarShowDetails.class.getName());

    /**
     *Main method
     * @param args
     */
    public static void main(String[] args) {

        Handler consoleHandler;
        Handler fileHandler;
        try {
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler("./sirigaddepriyanka.log");
            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);

            LOGGER.config("Configuration done.");
            LOGGER.removeHandler(consoleHandler);
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }

        CarShowMainMenu.runPortfolioProject();
    }
}
