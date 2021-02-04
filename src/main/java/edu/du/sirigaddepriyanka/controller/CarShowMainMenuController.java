/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.controller;

import edu.du.sirigaddepriyanka.model.business.manager.persistmanager.PersistManager;
import edu.du.sirigaddepriyanka.view.CarShowMainMenu;
import edu.du.sirigaddepriyanka.view.CarShowUI;
import edu.du.sirigaddepriyanka.view.OwnerUI;
import edu.du.sirigaddepriyanka.view.VehicleUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowMainMenuController implements ActionListener, WindowListener {

    private CarShowMainMenu carShowMainMenu = null;
    private static final Logger LOGGER = Logger.getLogger(CarShowMainMenuController.class.getName());
    public static int count = 0;

    public CarShowMainMenuController() {
    }

    public CarShowMainMenuController(CarShowMainMenu carShowMainMenu) {
        this.carShowMainMenu = carShowMainMenu;

        carShowMainMenu.addWindowListener(this);
        carShowMainMenu.getExitMenuItem().addActionListener(this);
        carShowMainMenu.getOwnerMenuItem().addActionListener(this);
        carShowMainMenu.getVehicleMenuItem().addActionListener(this);
        carShowMainMenu.getCarShowMenuItem().addActionListener(this);
        carShowMainMenu.getSubmitButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource().equals(carShowMainMenu.getExitMenuItem())) {
                exitItem_actionPerformed(event);
            } else if (event.getSource().equals(carShowMainMenu.getOwnerMenuItem())) {
                ownerMenuItem_actionPerformed(event);
            } else if (event.getSource().equals(carShowMainMenu.getVehicleMenuItem())) {
                vehicleMenuItem_actionPerformed(event);
            } else if (event.getSource().equals(carShowMainMenu.getCarShowMenuItem())) {
                carShowMenuItem_actionPerformed(event);
            } else if (event.getSource().equals(carShowMainMenu.getSubmitButton())) {
                submitButton_actionPerformed(event);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Exception occurred while performing action :", ex);
        }
    }

    private void exitItem_actionPerformed(ActionEvent event) throws Exception {
        PersistManager persistManager = CarShowMainMenu.getPersistManager();
        persistManager.putPersistData(CarShowMainMenu.getOwnerManager(), CarShowMainMenu.getVehicleManager(),
                CarShowMainMenu.getCarShowManager(), CarShowMainMenu.getCarShowOwnerManager());
        System.exit(0);
    }

    private void ownerMenuItem_actionPerformed(ActionEvent event) throws Exception {
        OwnerUI ownerUI = new OwnerUI(carShowMainMenu);
        ownerUI.setVisible(true);
    }

    private void vehicleMenuItem_actionPerformed(ActionEvent event) throws Exception {
        VehicleUI vehicleUI = new VehicleUI(carShowMainMenu);
        vehicleUI.setVisible(true);
    }

    private void carShowMenuItem_actionPerformed(ActionEvent event) throws Exception {
        CarShowUI carShowUI = new CarShowUI(carShowMainMenu);
        carShowUI.setVisible(true);
    }

    private void submitButton_actionPerformed(ActionEvent event) throws IOException {

        if ((carShowMainMenu.getUserIDTextField() != null) && (carShowMainMenu.getPasswordField() != null)) {
            try {
                char[] correctPassword = new char[]{'1', '2', '3', '4', '5', '6'};
                if ((carShowMainMenu.getUserIDTextField().getText().equals("PRIYANKA"))
                        && (Arrays.equals(correctPassword, carShowMainMenu.getPasswordField().getPassword()))) {
                    carShowMainMenu.getOwnerMenuItem().setEnabled(true);
                    carShowMainMenu.getOwnerMenuItem().setVisible(true);
                    carShowMainMenu.getVehicleMenuItem().setEnabled(true);
                    carShowMainMenu.getVehicleMenuItem().setVisible(true);
                    carShowMainMenu.getCarShowMenuItem().setEnabled(true);
                    carShowMainMenu.getCarShowMenuItem().setVisible(true);
                    carShowMainMenu.getCarShowOwnerMenuItem().setEnabled(true);
                    carShowMainMenu.getCarShowOwnerMenuItem().setVisible(true);
                    carShowMainMenu.getUserIDLabel().setVisible(false);
                    carShowMainMenu.getUserIDTextField().setVisible(false);
                    carShowMainMenu.getPasswordLabel().setVisible(false);
                    carShowMainMenu.getPasswordField().setVisible(false);
                    carShowMainMenu.getSubmitButton().setVisible(false);
                    JOptionPane.showMessageDialog(carShowMainMenu.getContainer(), "Authentication Success");

                } else {
                    JOptionPane.showMessageDialog(carShowMainMenu.getContainer(), "Authentication Failure, Enter correct User ID and Password");
                    count = count + 1;
                    if (count >= 3) {
                        JOptionPane.showMessageDialog(carShowMainMenu.getContainer(), "Reached maximum number of attempts");
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(CarShowMainMenuController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            PersistManager persistManager = CarShowMainMenu.getPersistManager();
            persistManager.putPersistData(CarShowMainMenu.getOwnerManager(), CarShowMainMenu.getVehicleManager(),
                    CarShowMainMenu.getCarShowManager(), CarShowMainMenu.getCarShowOwnerManager());
        } catch (Exception ex) {
            Logger.getLogger(CarShowMainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
