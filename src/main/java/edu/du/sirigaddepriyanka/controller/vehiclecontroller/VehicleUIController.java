/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.controller.vehiclecontroller;

import edu.du.sirigaddepriyanka.model.business.manager.ownermanager.OwnerManager;
import edu.du.sirigaddepriyanka.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.sirigaddepriyanka.model.domain.Vehicle;
import edu.du.sirigaddepriyanka.view.VehicleUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author priyankasirigadde
 */
public class VehicleUIController implements ActionListener {

    VehicleUI vehicleUI = null;

    public VehicleUIController() {
    }

    public VehicleUIController(VehicleUI vehicleUI) {
        this.vehicleUI = vehicleUI;

        vehicleUI.getVehicleFindButton().addActionListener(this);
        vehicleUI.getVehicleAddButton().addActionListener(this);
        vehicleUI.getVehicleRemoveButton().addActionListener(this);
        vehicleUI.getExitMenuItem().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource().equals(vehicleUI.getVehicleFindButton())) {
                find_actionPerformed(event);
            } else if (event.getSource().equals(vehicleUI.getVehicleAddButton())) {
                add_actionPerformed(event);
            } else if (event.getSource().equals(vehicleUI.getVehicleRemoveButton())) {
                remove_actionPerformed(event);
            } else if (event.getSource().equals(vehicleUI.getExitMenuItem())) {
                exit_actionPerformed(event);
            }
        } catch (Exception e) {

        }
    }

    private void find_actionPerformed(ActionEvent event) throws Exception {
        String vehicleID = (String) vehicleUI.getVehicleIDComboBox().getSelectedItem();

        VehicleManager vehicleManager = vehicleUI.getVehicleManager();
        Vehicle vehicle = vehicleManager.find(vehicleID);
        if (vehicle != null) {
            vehicleUI.putVehicleInfo(vehicle);
        } else {
            JOptionPane.showMessageDialog(vehicleUI.getContainer(), "Vehicle was not found");
        }

    }

    private void add_actionPerformed(ActionEvent event) {

        try {
            Vehicle vehicle = vehicleUI.getVehicleInfo();
            VehicleManager vehicleManager = new VehicleManager();
            OwnerManager ownerManager = new OwnerManager();
            if (vehicleManager.isUnique(vehicle.getVehicleID())) {
                if (ownerManager.isUnique(vehicle.getOwnerID()) == false) {
                    if (vehicleManager.add(vehicle) == true) {
                        JOptionPane.showMessageDialog(vehicleUI.getContainer(), vehicle.getVehicleID() + " : Vehicle added");
                        vehicleUI.getVehicleIDComboBox().addItem(vehicle.getVehicleID());
                        vehicleUI.getVehicleIDComboBox().setSelectedItem(vehicle.getVehicleID());
                        vehicleUI.getOwnerIDComboBox().setSelectedItem(vehicle.getOwnerID());
                        vehicleUI.getVehicleClassificationComboBox().setSelectedIndex(Integer.parseInt(vehicle.getVehicleClassification().toString()));
                    } else {
                        JOptionPane.showMessageDialog(vehicleUI.getContainer(), "Exception while adding vehicle : " + vehicle.toString());
                    }
                } else {
                    JOptionPane.showMessageDialog(vehicleUI.getContainer(), "Owner does not exist for : " + vehicle.toString());
                }
            } else {
                JOptionPane.showMessageDialog(vehicleUI.getContainer(), "Vehicle already exists with ID : " + vehicle.toString());
            }
        } catch (Exception e) {

        }
    }

    private void remove_actionPerformed(ActionEvent event) throws Exception {
        String vehicleID = (String) vehicleUI.getVehicleIDComboBox().getSelectedItem();
        VehicleManager vehicleManager = new VehicleManager();
        Vehicle vehicle = vehicleManager.find(vehicleID);
        if (vehicleManager.remove(vehicleID) == true) {
            vehicleUI.getVehicleIDComboBox().removeItem(vehicleID);
            vehicleUI.clearVehicleInfo();
            JOptionPane.showMessageDialog(vehicleUI.getContainer(), vehicle.getVehicleID() + " has been removed");
            vehicleUI.getVehicleIDComboBox().setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(vehicleUI.getContainer(), "Exception while removing Vehicle : " + vehicle.getVehicleID());
        }
    }

    private void exit_actionPerformed(ActionEvent event) {
        vehicleUI.setVisible(false);
    }

}
