/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.controller.carshowcontroller;

import edu.du.sirigaddepriyanka.model.business.manager.carshowmanager.CarShowManager;
import edu.du.sirigaddepriyanka.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.sirigaddepriyanka.model.domain.CarShow;
import edu.du.sirigaddepriyanka.view.CarShowUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author priyankasirigadde
 */
public class CarShowUIController implements ActionListener {

    CarShowUI carShowUI = null;

    public CarShowUIController() {
    }

    public CarShowUIController(CarShowUI carShowUI) {
        this.carShowUI = carShowUI;

        carShowUI.getCarShowFindButton().addActionListener(this);
        carShowUI.getCarShowAddButton().addActionListener(this);
        carShowUI.getCarShowRemoveButton().addActionListener(this);
        carShowUI.getExitMenuItem().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource().equals(carShowUI.getCarShowFindButton())) {
                find_actionPerformed(event);
            } else if (event.getSource().equals(carShowUI.getCarShowAddButton())) {
                add_actionPerformed(event);
            } else if (event.getSource().equals(carShowUI.getCarShowRemoveButton())) {
                remove_actionPerformed(event);
            } else if (event.getSource().equals(carShowUI.getExitMenuItem())) {
                exit_actionPerformed(event);
            }
        } catch (Exception e) {

        }
    }

    private void find_actionPerformed(ActionEvent event) throws Exception {
        String carShowID = (String) carShowUI.getCarShowIDComboBox().getSelectedItem();

        CarShowManager carShowManager = carShowUI.getCarShowManager();
        CarShow carShow = carShowManager.find(carShowID);
        if (carShow != null) {
            carShowUI.putCarShowInfo(carShow);
        } else {
            JOptionPane.showMessageDialog(carShowUI.getContainer(), "CarShow was not found");
        }
    }

    private void add_actionPerformed(ActionEvent event) {
        try {
            CarShow carShow = carShowUI.getCarShowInfo();
            CarShowManager carShowManager = new CarShowManager();
            if (carShowManager.isUnique(carShow.getCarShowID()) == true) {
                if (carShowManager.add(carShow) == true) {
                    JOptionPane.showMessageDialog(carShowUI.getContainer(), carShow.getCarShowID() + " : Car Show added");
                    carShowUI.getCarShowIDComboBox().addItem(carShow.getCarShowID());
                    carShowUI.getCarShowIDComboBox().setSelectedItem(carShow.getCarShowID());
                } else {
                    JOptionPane.showMessageDialog(carShowUI.getContainer(), "Exception while adding car show : " + carShow.getCarShowID());
                }
            } else {
                JOptionPane.showMessageDialog(carShowUI.getContainer(), "Car show already exists with ID : " + carShow.getCarShowID());
            }
        } catch (Exception e) {

        }
    }

    private void remove_actionPerformed(ActionEvent event) throws Exception {
        String carShowID = (String) carShowUI.getCarShowIDComboBox().getSelectedItem();
        CarShowManager carShowManager = new CarShowManager();
        CarShow carShow = carShowManager.find(carShowID);
        if (carShowManager.remove(carShowID) == true) {
            CarShowOwnerManager carShowOwnerManager = carShowUI.getCarShowOwnerManager();
            carShowOwnerManager.removeByCarShow(carShowID);

            carShowUI.getCarShowIDComboBox().removeItem(carShowID);
            carShowUI.clearCarShowInfo();

            JOptionPane.showMessageDialog(carShowUI.getContainer(), carShow.getCarShowID() + " has been removed");
            carShowUI.getCarShowIDComboBox().setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(carShowUI.getContainer(), "Exception while removing CarShow : " + carShow.getCarShowID());
        }

    }

    private void exit_actionPerformed(ActionEvent event) {
        carShowUI.setVisible(false);
    }

}
