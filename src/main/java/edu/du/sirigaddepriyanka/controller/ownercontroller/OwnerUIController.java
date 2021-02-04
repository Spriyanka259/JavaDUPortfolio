/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.controller.ownercontroller;

import edu.du.sirigaddepriyanka.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.sirigaddepriyanka.model.business.manager.ownermanager.OwnerManager;
import edu.du.sirigaddepriyanka.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.sirigaddepriyanka.model.domain.Owner;
import edu.du.sirigaddepriyanka.view.OwnerUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author priyankasirigadde
 */
public class OwnerUIController implements ActionListener {

    OwnerUI ownerUI = null;

    public OwnerUIController() {
    }

    public OwnerUIController(OwnerUI ownerUI) {
        this.ownerUI = ownerUI;

        ownerUI.getOwnerFindButton().addActionListener(this);
        ownerUI.getOwnerAddButton().addActionListener(this);
        ownerUI.getOwnerRemoveButton().addActionListener(this);
        ownerUI.getExitMenuItem().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource().equals(ownerUI.getOwnerFindButton())) {
                find_actionPerformed(event);
            } else if (event.getSource().equals(ownerUI.getOwnerAddButton())) {
                add_actionPerformed(event);
            } else if (event.getSource().equals(ownerUI.getOwnerRemoveButton())) {
                remove_actionPerformed(event);
            } else if (event.getSource().equals(ownerUI.getExitMenuItem())) {
                exit_actionPerformed(event);
            }
        } catch (Exception e) {

        }
    }

    private void find_actionPerformed(ActionEvent event) throws Exception {
        String ownerID = (String) ownerUI.getOwnerIDComboBox().getSelectedItem();

        OwnerManager ownerManager = ownerUI.getOwnerManager();
        Owner owner = ownerManager.find(ownerID);
        if (owner != null) {
            ownerUI.putOwnerInfo(owner);
        } else {
            JOptionPane.showMessageDialog(ownerUI.getContainer(), "Owner was not found");
        }
    }

    private void add_actionPerformed(ActionEvent event) throws Exception {
        Owner owner = ownerUI.getOwnerInfo();
        if (owner.getAddress().validateState() == true) {
            if (owner.getAddress().validateZipcode() == true) {
                OwnerManager ownerManager = ownerUI.getOwnerManager();

                if (ownerManager.isUnique(owner.getOwnerID()) == true) {
                    if (ownerManager.add(owner) == true) {
                        ownerUI.getOwnerIDComboBox().addItem(owner.getOwnerID());
                        ownerUI.getOwnerIDComboBox().setSelectedItem(owner.getOwnerID());
                        JOptionPane.showMessageDialog(ownerUI.getContainer(), owner.getFirstName() + " " + owner.getLastName() + " has been added");

                    } else {
                        JOptionPane.showMessageDialog(ownerUI.getContainer(), "Exception while adding Owner : " + owner.getFirstName() + " " + owner.getLastName());
                    }
                } else {
                    JOptionPane.showMessageDialog(ownerUI.getContainer(), owner.getFirstName() + " " + owner.getLastName() + " already exists");
                }
            } else {
                JOptionPane.showMessageDialog(ownerUI.getContainer(), owner.getAddress().getZipcode() + " is not valid! It must be in Zip+4 format");
            }
        } else {
            JOptionPane.showMessageDialog(ownerUI.getContainer(), owner.getAddress().getState() + " is not valid! Enter 2 characters");
        }
    }

    private void remove_actionPerformed(ActionEvent event) throws Exception {
        String ownerID = (String) ownerUI.getOwnerIDComboBox().getSelectedItem();
        OwnerManager ownerManager = ownerUI.getOwnerManager();
        Owner owner = ownerManager.find(ownerID);
        if (ownerManager.remove(ownerID) == true) {
            VehicleManager vehicleManager = ownerUI.getVehicleManager();
            vehicleManager.removeByOwner(ownerID);

            CarShowOwnerManager carShowOwnerManager = ownerUI.getCarShowOwnerManager();
            carShowOwnerManager.removeByOwner(ownerID);
            ownerUI.getOwnerIDComboBox().removeItem(ownerID);
            ownerUI.clearOwnerInfo();

            JOptionPane.showMessageDialog(ownerUI.getContainer(), owner.getFirstName() + " " + owner.getLastName() + " has been removed");
            ownerUI.getOwnerIDComboBox().setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(ownerUI.getContainer(), "Exception while removing Owner : " + owner.getFirstName() + " " + owner.getLastName());
        }
    }

    private void exit_actionPerformed(ActionEvent event) {
        ownerUI.setVisible(false);
    }

}
