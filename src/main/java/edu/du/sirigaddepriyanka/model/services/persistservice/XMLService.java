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
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author manni
 */
public class XMLService implements IPersistService {
    
    private final static String XMLFILE = "XML4361.xml";
    
    @Override
    public void loadPersistData(OwnerManager ownerManager, VehicleManager vehicleManager, 
                                CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) {
        System.out.println("XML loadPersistData");
    
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(XMLFILE);
            if (file.exists()) {
                Document doc = db.parse(file);
                Element rootElement = doc.getDocumentElement();
                NodeList ownerList = rootElement.getElementsByTagName("Owner");
                NodeList vehicleList = rootElement.getElementsByTagName("Vehicle");
                NodeList carShowList = rootElement.getElementsByTagName("CarShow");
                NodeList carShowOwnerList = rootElement.getElementsByTagName("CarShowOwner");           

                for (int idx = 0;idx < ownerList.getLength();idx++) {
                    Owner owner = new Owner();
                    Node node = ownerList.item(idx);
                    if (node.getNodeType() == Node.ELEMENT_NODE){

                        Element ownerElement = (Element)node;
                        NodeList nodeList = ownerElement.getElementsByTagName("ownerID");
                        owner.setOwnerID(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("lastName");
                        owner.setLastName(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("firstName");
                        owner.setFirstName(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("phoneNumber");
                        owner.setPhoneNumber(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("numYears");
                        owner.setNumYears(Integer.parseInt(nodeList.item(0).getChildNodes().item(0).getNodeValue()));
                        
                        NodeList addressList = ownerElement.getElementsByTagName("Address");
                        Address address = new Address();
                        node = addressList.item(0);

                        if (node.getNodeType() == Node.ELEMENT_NODE){

                            Element addressElement = (Element)node;
                            nodeList = addressElement.getElementsByTagName("street1");
                            address.setStreet1(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                            nodeList = addressElement.getElementsByTagName("city");
                            address.setCity(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                            nodeList = addressElement.getElementsByTagName("state");
                            address.setState(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                            nodeList = addressElement.getElementsByTagName("zipCode");
                            address.setZipcode(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        }

                        owner.setAddress(address);
                        ownerManager.add(owner);
                    }
                }
                
                for (int idx = 0;idx < vehicleList.getLength();idx++) {
                    Vehicle vehicle = new Vehicle();
                    Node node = vehicleList.item(idx);
                    if (node.getNodeType() == Node.ELEMENT_NODE){

                        Element ownerElement = (Element)node;
                        NodeList nodeList = ownerElement.getElementsByTagName("vehicleID");
                        vehicle.setVehicleID(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("ownerID");
                        vehicle.setOwnerID(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("manufacturer");
                        vehicle.setManufacturer(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("modelYear");
                        vehicle.setModelYear(Integer.parseInt(nodeList.item(0).getChildNodes().item(0).getNodeValue()));
                        nodeList = ownerElement.getElementsByTagName("model");
                        vehicle.setModel(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("subModel");
                        vehicle.setSubModel(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("vehicleClassification");
                        vehicle.setVehicleClassification(VehicleClassification.valueOf(nodeList.item(0).getChildNodes().item(0).getNodeValue()));
                        nodeList = ownerElement.getElementsByTagName("isInsured");
                        vehicle.setIsInsured(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                       
                        vehicleManager.add(vehicle);
                    }
                }
                
                for (int idx = 0;idx < carShowList.getLength();idx++) {
                    
                    CarShow carShow = new CarShow();
                    Node node = carShowList.item(idx);
                    if (node.getNodeType() == Node.ELEMENT_NODE){

                        Element ownerElement = (Element)node;
                        NodeList nodeList = ownerElement.getElementsByTagName("carShowID");
                        carShow.setCarShowID(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("carShowTitle");
                        carShow.setCarShowTitle(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("carShowDate");
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        carShow.setCarShowDate(date);
                        nodeList = ownerElement.getElementsByTagName("isSanctioned");
                        carShow.setIsSanctioned(Boolean.parseBoolean(nodeList.item(0).getChildNodes().item(0).getNodeValue()));
                        
                        carShowManager.add(carShow);
                    }
                }
                
                for (int idx = 0;idx < carShowOwnerList.getLength();idx++) {
                    
                    CarShowOwner carShowOwner = new CarShowOwner();
                    Node node = carShowOwnerList.item(idx);
                    if (node.getNodeType() == Node.ELEMENT_NODE){

                        Element ownerElement = (Element)node;
                        NodeList nodeList = ownerElement.getElementsByTagName("carShowID");
                        carShowOwner.setCarShowID(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        nodeList = ownerElement.getElementsByTagName("ownerID");
                        carShowOwner.setOwnerID(nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        
                        carShowOwnerManager.add(carShowOwner);
                    }
                }
            }
        } catch (Exception e1) {
           System.out.println("exception " + e1.getMessage());
        }
    }  
  
    @Override
    public void putPersistData(OwnerManager ownerManager, VehicleManager vehicleManager, CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) {
        System.out.println ("XMLService putPersistData");   
        
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            
            Element rootElement = document.createElement("GeorgeWashington");
            document.appendChild(rootElement);
            
            ArrayList<Owner> ownerArrayList = ownerManager.getArrayList();
            ArrayList<Vehicle> vehicleArrayList = vehicleManager.getArrayList();
            ArrayList<CarShow> carShowArrayList = carShowManager.getArrayList();
            ArrayList<CarShowOwner> carShowOwnerArrayList = carShowOwnerManager.getArrayList();
          
            for (Owner owner : ownerArrayList) {
                Element ownerElement = document.createElement("Owner");
                rootElement.appendChild(ownerElement);
                
                Element ownerID = document.createElement("ownerID");
                ownerID.appendChild(document.createTextNode(owner.getOwnerID()));
                ownerElement.appendChild(ownerID);
                
                Element lastName = document.createElement("lastName");
                lastName.appendChild(document.createTextNode(owner.getLastName()));
                ownerElement.appendChild(lastName);
                
                Element firstName = document.createElement("firstName");
                firstName.appendChild(document.createTextNode(owner.getFirstName()));
                ownerElement.appendChild(firstName);
                
                Element phoneNumber = document.createElement("phoneNumber");
                phoneNumber.appendChild(document.createTextNode(owner.getPhoneNumber()));
                ownerElement.appendChild(phoneNumber);
                
                Element numYears = document.createElement("numYears");
                String numYearsString = Integer.toString(owner.getNumYears());
                numYears.appendChild(document.createTextNode(numYearsString));
                ownerElement.appendChild(numYears);
                
                Element addressElement = document.createElement("Address");
                ownerElement.appendChild(addressElement);
                
                Address address = owner.getAddress();
                
                Element street1 = document.createElement("street1");
                street1.appendChild(document.createTextNode(address.getStreet1()));
                addressElement.appendChild(street1);
                
                Element street2 = document.createElement("street2");
                street2.appendChild(document.createTextNode(address.getStreet2()));
                addressElement.appendChild(street2);
                
                Element city = document.createElement("city");
                city.appendChild(document.createTextNode(address.getCity()));
                addressElement.appendChild(city);
                
                Element state = document.createElement("state");
                state.appendChild(document.createTextNode(address.getState()));
                addressElement.appendChild(state);
                
                Element zipCode = document.createElement("zipCode");
                zipCode.appendChild(document.createTextNode(address.getZipcode()));
                addressElement.appendChild(zipCode);
            }
            
            for (Vehicle vehicle : vehicleArrayList) {
                Element vehicleElement = document.createElement("Vehicle");
                rootElement.appendChild(vehicleElement);
                
                Element vehicleID = document.createElement("vehicleID");
                vehicleID.appendChild(document.createTextNode(vehicle.getVehicleID()));
                vehicleElement.appendChild(vehicleID);
                
                Element ownerID = document.createElement("ownerID");
                ownerID.appendChild(document.createTextNode(vehicle.getOwnerID()));
                vehicleElement.appendChild(ownerID);
                
                Element manufacturer = document.createElement("manufacturer");
                manufacturer.appendChild(document.createTextNode(vehicle.getManufacturer()));
                vehicleElement.appendChild(manufacturer);
                
                Element modelYear = document.createElement("modelYear");
                modelYear.appendChild(document.createTextNode(String.valueOf(vehicle.getModelYear())));
                vehicleElement.appendChild(modelYear);
                
                Element model = document.createElement("model");
                model.appendChild(document.createTextNode(vehicle.getModel()));
                vehicleElement.appendChild(model);
                
                Element subModel = document.createElement("subModel");
                subModel.appendChild(document.createTextNode(vehicle.getSubModel()));
                vehicleElement.appendChild(subModel);
                
                Element vehicleClassification = document.createElement("vehicleClassification");
                vehicleClassification.appendChild(document.createTextNode(vehicle.getVehicleClassification().toString()));
                vehicleElement.appendChild(vehicleClassification);
                
                Element isInsured = document.createElement("isInsured");
                isInsured.appendChild(document.createTextNode(Boolean.toString(vehicle.isIsInsured())));
                vehicleElement.appendChild(isInsured);
         
            }
            
            for (CarShow carShow : carShowArrayList) {
                Element carShowElement = document.createElement("CarShow");
                rootElement.appendChild(carShowElement);
                
                Element carShowID = document.createElement("carShowID");
                carShowID.appendChild(document.createTextNode(carShow.getCarShowID()));
                carShowElement.appendChild(carShowID);
                
                Element carShowTitle = document.createElement("carShowTitle");
                carShowTitle.appendChild(document.createTextNode(carShow.getCarShowTitle()));
                carShowElement.appendChild(carShowTitle);
                
                Element carShowDate = document.createElement("carShowDate");
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                String strDate = dateFormat.format(carShow.getCarShowDate());  
                carShowDate.appendChild(document.createTextNode(strDate));
                carShowElement.appendChild(carShowDate);
                
                Element isSanctioned = document.createElement("isSanctioned");
                isSanctioned.appendChild(document.createTextNode(Boolean.toString(carShow.isIsSanctioned())));
                carShowElement.appendChild(isSanctioned);
         
            }
            
            for (CarShowOwner carShowOwner : carShowOwnerArrayList) {
                Element carShowOwnerElement = document.createElement("CarShowOwner");
                rootElement.appendChild(carShowOwnerElement);
                
                Element carShowID = document.createElement("carShowID");
                carShowID.appendChild(document.createTextNode(carShowOwner.getCarShowID()));
                carShowOwnerElement.appendChild(carShowID);
                
                Element ownerID = document.createElement("ownerID");
                ownerID.appendChild(document.createTextNode(carShowOwner.getOwnerID()));
                carShowOwnerElement.appendChild(ownerID);
         
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(XMLFILE));
            transformer.transform(source, result);
            
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
            
        } catch (IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException e) {
            System.out.println (e.getMessage());
            
        } catch (Exception ex) {
            System.out.println (ex.getMessage());
        }
    }
    
}