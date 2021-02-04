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
import edu.du.sirigaddepriyanka.model.domain.Address;
import edu.du.sirigaddepriyanka.model.domain.CarShow;
import edu.du.sirigaddepriyanka.model.domain.CarShowOwner;
import edu.du.sirigaddepriyanka.model.domain.Owner;
import edu.du.sirigaddepriyanka.model.domain.Vehicle;
import edu.du.sirigaddepriyanka.model.domain.VehicleClassification;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author manni
 */
public class JSONService implements IPersistService {

    private static final String JSONFILE = "JSON4361.json";

    @Override
    public void loadPersistData(OwnerManager ownerManager, VehicleManager vehicleManager, CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) {
        System.out.println("JSONService loadPersistData");
        String jsonString = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(JSONFILE));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            jsonString = sb.toString();
        } catch (IOException e) {
            System.out.println("Exception while loading JSON file");
        }

        
        JSONObject obj1 = new JSONObject(jsonString);
        JSONArray JSONownerArray1 = obj1.getJSONArray("sirigaddepriyanka");
        for (int i = 0; i < JSONownerArray1.length(); i++) {
            JSONArray JSONownerArray = JSONownerArray1.getJSONObject(0).getJSONArray("Owner");
            for (int idx = 0; idx < JSONownerArray.length(); idx++) {
                Owner owner = new Owner();
                owner.setOwnerID(JSONownerArray.getJSONObject(idx).getString("ownerID"));
                owner.setLastName(JSONownerArray.getJSONObject(idx).getString("lastName"));
                owner.setFirstName(JSONownerArray.getJSONObject(idx).getString("firstName"));
                owner.setPhoneNumber(JSONownerArray.getJSONObject(idx).getString("phoneNumber"));
                owner.setNumYears(JSONownerArray.getJSONObject(idx).getInt("numYears"));
                Address address = new Address();
                JSONObject jsonAddress = JSONownerArray.getJSONObject(idx).getJSONObject("address");

                address.setStreet1(jsonAddress.getString("street1"));
                address.setStreet2(jsonAddress.getString("street2"));
                address.setCity(jsonAddress.getString("city"));
                address.setState(jsonAddress.getString("state"));
                address.setZipcode(jsonAddress.getString("zipcode"));
                owner.setAddress(address);

                try {
                    ownerManager.add(owner);
                } catch (Exception ex) {
                    System.out.println("Exception while adding owner through JSON service" + ex);
                }

            }

            JSONArray JSONvehicleArray = JSONownerArray1.getJSONObject(1).getJSONArray("Vehicle");
            for (int idx = 0; idx < JSONvehicleArray.length(); idx++) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleID(JSONvehicleArray.getJSONObject(idx).getString("vehicleID"));
                vehicle.setOwnerID(JSONvehicleArray.getJSONObject(idx).getString("ownerID"));
                vehicle.setManufacturer(JSONvehicleArray.getJSONObject(idx).getString("manufacturer"));
                vehicle.setModelYear(JSONvehicleArray.getJSONObject(idx).getInt("modelYear"));
                vehicle.setModel(JSONvehicleArray.getJSONObject(idx).getString("model"));
                vehicle.setSubModel(JSONvehicleArray.getJSONObject(idx).getString("subModel"));
                JSONObject jsonVehicleClassification = JSONvehicleArray.getJSONObject(idx).getJSONObject("vehicleClassification");
                vehicle.setVehicleClassification(jsonVehicleClassification.getEnum(VehicleClassification.class, "status"));
                vehicle.setIsInsured(JSONvehicleArray.getJSONObject(idx).getBoolean("isInsured"));

                try {
                    vehicleManager.add(vehicle);
                } catch (Exception ex) {
                    System.out.println("Exception while adding vehicle through JSON service" + ex);
                }

            }

            JSONArray JSONcarShowArray = JSONownerArray1.getJSONObject(2).getJSONArray("CarShow");
            for (int idx = 0; idx < JSONcarShowArray.length(); idx++) {
                CarShow carShow = new CarShow();
                carShow.setCarShowID(JSONcarShowArray.getJSONObject(idx).getString("carShowID"));
                carShow.setCarShowTitle(JSONcarShowArray.getJSONObject(idx).getString("carShowTitle"));
                String date = JSONcarShowArray.getJSONObject(idx).getString("carShowDate");
                Date date1 = null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                } catch (ParseException ex) {
                    System.out.println("Enter correct format for the date i.e., 'dd/MM/yyyy' " + ex);
                }
                carShow.setCarShowDate(date1);
                carShow.setIsSanctioned(JSONcarShowArray.getJSONObject(idx).getBoolean("isSanctioned"));

                try {
                    carShowManager.add(carShow);
                } catch (Exception ex) {
                    System.out.println("Exception while adding carShow through JSON service" + ex);
                }

            }

            JSONArray JSONcarShowOwnerArray = JSONownerArray1.getJSONObject(3).getJSONArray("CarShowOwner");
            for (int idx = 0; idx < JSONcarShowOwnerArray.length(); idx++) {
                CarShowOwner carShowOwner = new CarShowOwner();
                carShowOwner.setCarShowID(JSONcarShowOwnerArray.getJSONObject(idx).getString("carShowID"));
                carShowOwner.setOwnerID(JSONcarShowOwnerArray.getJSONObject(idx).getString("ownerID"));

                try {
                    carShowOwnerManager.add(carShowOwner);
                } catch (Exception ex) {
                    System.out.println("Exception while adding carShowOwner through JSON service" + ex);
                }

            }
        }
    }

    @Override
    public void putPersistData(OwnerManager ownerManager, VehicleManager vehicleManager, CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) {
        System.out.println("JSONService putPersistData");
        try {
            ArrayList<Owner> ownerArrayList = ownerManager.getArrayList();
            JSONArray outputArray = new JSONArray();
            JSONObject JSONowner;
            JSONArray JSONownerArray = new JSONArray();

            for (Owner owner : ownerArrayList) {
                JSONowner = new JSONObject(owner);
                JSONownerArray.put(JSONowner);
            }
            JSONObject owners = new JSONObject();
            owners.put("Owner", JSONownerArray);
            outputArray.put(owners);

            ArrayList<Vehicle> vehicleArrayList = vehicleManager.getArrayList();
            JSONObject JSONvehicle;
            JSONArray JSONvehicleArray = new JSONArray();

            for (Vehicle vehicle : vehicleArrayList) {
                JSONvehicle = new JSONObject(vehicle);
                JSONvehicleArray.put(JSONvehicle);
            }
            JSONObject vehicles = new JSONObject();
            vehicles.put("Vehicle", JSONvehicleArray);
            outputArray.put(vehicles);

            ArrayList<CarShow> carShowArrayList = carShowManager.getArrayList();
            JSONObject JSONcarShow;
            JSONArray JSONcarShowArray = new JSONArray();

            for (CarShow carShow : carShowArrayList) {
                JSONcarShow = new JSONObject(carShow);
                JSONcarShowArray.put(JSONcarShow);
            }
            JSONObject carShows = new JSONObject();
            carShows.put("CarShow", JSONcarShowArray);
            outputArray.put(carShows);

            ArrayList<CarShowOwner> carShowOwnerArrayList = carShowOwnerManager.getArrayList();
            JSONObject JSONcarShowOwner;
            JSONArray JSONcarShowOwnerArray = new JSONArray();

            for (CarShowOwner carShowOwner : carShowOwnerArrayList) {
                JSONcarShowOwner = new JSONObject(carShowOwner);
                JSONcarShowOwnerArray.put(JSONcarShowOwner);
            }
            JSONObject carShowOwners = new JSONObject();
            carShowOwners.put("CarShowOwner", JSONcarShowOwnerArray);
            outputArray.put(carShowOwners);

            JSONObject output = new JSONObject();
            output.put("sirigaddepriyanka", outputArray);

            try (FileWriter file = new FileWriter(JSONFILE)) {
                file.write(output.toString(4));
                System.out.println(output.toString(4));
                file.flush();
            }
        } catch (Exception e2) {
            System.out.println("Exception while writing vehicle through JSON service " + e2.getMessage());
        }
    }

}
